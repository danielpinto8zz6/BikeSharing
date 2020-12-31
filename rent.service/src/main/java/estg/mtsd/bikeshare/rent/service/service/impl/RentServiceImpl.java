package estg.mtsd.bikeshare.rent.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.rent.service.dao.RentDao;
import estg.mtsd.bikeshare.rent.service.entity.Rent;
import estg.mtsd.bikeshare.rent.service.service.DockServiceProxy;
import estg.mtsd.bikeshare.rent.service.service.RentService;
import estg.mtsd.bikeshare.rent.service.vo.RentVo;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	RentDao rentDao;

	@Autowired
	private DockServiceProxy dockService;

	@Override
	@Transactional
	public void save(RentVo rentVo) throws Exception {
		Integer dockId = rentVo.getDockId();
		Integer bikeId = rentVo.getBikeId();

		// Check if bike is still available
		boolean isBikeAvailable = dockService.dockHasBike(dockId, bikeId);
		if (!isBikeAvailable) {
			throw new Exception("Bike is not available!");
		}

		Rent rent = new Rent();
		BeanUtils.copyProperties(rentVo, rent);
	}

	@Override
	@Transactional
	public void update(RentVo rentVo) {
		Integer id = rentVo.getId();
		Boolean objectExists = rentDao.existsById(id);
		if (objectExists) {
			Rent rent = new Rent();
			BeanUtils.copyProperties(rentVo, rent);
			rentDao.save(rent);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists = rentDao.existsById(id);
		if (objectExists) {
			rentDao.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public RentVo get(Integer id) {
		Optional<Rent> rentOptional = rentDao.findById(id);
		RentVo rentVo = null;
		if (rentOptional.isPresent()) {
			rentVo = new RentVo();
			BeanUtils.copyProperties(rentOptional.get(), rentVo);
		} else {
			throw new EntityNotFoundException();
		}

		return rentVo;
	}

	@Override
	@Transactional
	public List<RentVo> getAll() {
		List<Rent> rentList = rentDao.findAll();
		List<RentVo> rentVoList = new ArrayList<>();
		if (rentList != null && !rentList.isEmpty()) {
			for (Rent rent : rentList) {
				RentVo rentVo = new RentVo();
				BeanUtils.copyProperties(rent, rentVo);
				rentVoList.add(rentVo);
			}
		}
		return rentVoList;
	}

}
