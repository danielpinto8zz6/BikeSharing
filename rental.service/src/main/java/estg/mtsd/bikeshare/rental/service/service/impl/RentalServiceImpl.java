package estg.mtsd.bikeshare.rental.service.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import estg.mtsd.bikeshare.rental.service.entity.Rental;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.rental.service.dao.RentalDao;
import estg.mtsd.bikeshare.rental.service.producers.RentalProducer;
import estg.mtsd.bikeshare.rental.service.service.DockServiceProxy;
import estg.mtsd.bikeshare.rental.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	RentalDao rentalDao;

	@Autowired
	private DockServiceProxy dockService;

	@Autowired
	private RentalProducer rentalProducer;

	@Override
	@Transactional
	public RentalVo rental(RentalVo rentalVo) throws Exception {
		Integer dockId = rentalVo.getDockId();
		Integer bikeId = rentalVo.getBikeId();

		// Check if bike is still available
		boolean isBikeAvailable = dockService.dockHasBike(dockId, bikeId);
		if (!isBikeAvailable) {
			throw new Exception("Bike is not available!");
		}

		Rental rental = new Rental();
		BeanUtils.copyProperties(rentalVo, rental);
		rentalDao.save(rental);

		// Notify kafka to open dock and remove bike from dock
		BeanUtils.copyProperties(rental, rentalVo);
		rentalProducer.send(rentalVo);

		return rentalVo;
	}

	@Override
	@Transactional
	public void update(RentalVo rentalVo) {
		Integer id = rentalVo.getId();
		boolean objectExists = rentalDao.existsById(id);
		if (objectExists) {
			Rental rental = new Rental();
			BeanUtils.copyProperties(rentalVo, rental);
			rentalDao.save(rental);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		boolean objectExists = rentalDao.existsById(id);
		if (objectExists) {
			rentalDao.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public RentalVo get(Integer id) {
		Optional<Rental> rentOptional = rentalDao.findById(id);
		RentalVo rentalVo = null;
		if (rentOptional.isPresent()) {
			rentalVo = new RentalVo();
			BeanUtils.copyProperties(rentOptional.get(), rentalVo);
		} else {
			throw new EntityNotFoundException();
		}

		return rentalVo;
	}

	@Override
	@Transactional
	public Page<RentalVo> getAll(Pageable pageable, String email) {
		Page<Rental> entities = rentalDao.findAllByUserEmail(pageable, email);

		return entities.map(this::convertToRentalVo);
	}

	private RentalVo convertToRentalVo(Rental entity) {
		RentalVo rentalVo = new RentalVo();
		BeanUtils.copyProperties(entity, rentalVo);

		return rentalVo;
	}

}
