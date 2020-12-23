package estg.mtsd.bikeshare.bikemanagement.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.bikemanagement.service.dao.BikeDao;
import estg.mtsd.bikeshare.bikemanagement.service.entity.Bike;
import estg.mtsd.bikeshare.bikemanagement.service.service.BikeService;
import estg.mtsd.bikeshare.bikemanagement.service.vo.BikeVo;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	BikeDao bikeDao;

	@Override
	@Transactional
	public void save(BikeVo bikeVo) {	
		Integer id = bikeVo.getId();
		Boolean objectAlreadyExists=bikeDao.existsById(id);
		if(!objectAlreadyExists) {
			Bike bike = new Bike();
			BeanUtils.copyProperties(bikeVo, bike);
			bikeDao.save(bike);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(BikeVo bikeVo) {
		Integer id = bikeVo.getId();
		Boolean objectExists=bikeDao.existsById(id);
		if(objectExists) {
			Bike bike = new Bike();
			BeanUtils.copyProperties(bikeVo, bike);
			bikeDao.save(bike);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=bikeDao.existsById(id);
		if(objectExists) {
			bikeDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public BikeVo get(Integer id) {
		Optional<Bike> bikeOptional = bikeDao.findById(id);
		BikeVo bikeVo=null;
		if(bikeOptional.isPresent()) {
			bikeVo = new BikeVo();
			BeanUtils.copyProperties(bikeOptional.get(), bikeVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return bikeVo;
	}

	@Override
	@Transactional
	public List<BikeVo> getAll() {
		List<Bike> bikeList = bikeDao.findAll();
		List<BikeVo> bikeVoList = new ArrayList<>();
		if (bikeList != null && !bikeList.isEmpty()) {
			for (Bike bike : bikeList) {
				BikeVo bikeVo = new BikeVo();
				BeanUtils.copyProperties(bike, bikeVo);
				bikeVoList.add(bikeVo);
			}
		}
		return bikeVoList;
	}

}

