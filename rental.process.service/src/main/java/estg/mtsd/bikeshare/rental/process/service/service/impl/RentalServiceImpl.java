package estg.mtsd.bikeshare.rental.process.service.service.impl;

import estg.mtsd.bikeshare.rental.process.service.dao.RentalDao;
import estg.mtsd.bikeshare.rental.process.service.entity.Rental;
import estg.mtsd.bikeshare.rental.process.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	RentalDao rentalDao;

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
	public List<RentalVo> getAll() {
		List<Rental> rentalList = rentalDao.findAll();
		List<RentalVo> rentalVoList = new ArrayList<>();
		if (!rentalList.isEmpty()) {
			for (Rental rental : rentalList) {
				RentalVo rentalVo = new RentalVo();
				BeanUtils.copyProperties(rental, rentalVo);
				rentalVoList.add(rentalVo);
			}
		}
		return rentalVoList;
	}

}
