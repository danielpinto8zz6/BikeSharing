package estg.mtsd.bikeshare.travel.history.process.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.travel.history.process.service.dao.TravelDao;
import estg.mtsd.bikeshare.travel.history.process.service.entity.Travel;
import estg.mtsd.bikeshare.travel.history.process.service.service.TravelService;
import estg.mtsd.bikeshare.shared.library.vo.TravelVo;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	TravelDao travelDao;

	@Override
	public void save(TravelVo travelVo) {
		Integer id = travelVo.getId();
		Boolean objectAlreadyExists = travelDao.existsById(id);
		if (!objectAlreadyExists) {
			Travel travel = new Travel();
			BeanUtils.copyProperties(travelVo, travel);
			travelDao.save(travel);
		} else {
		}

	}

	@Override
	public void update(TravelVo travelVo) {
		Integer id = travelVo.getId();
		Boolean objectExists = travelDao.existsById(id);
		if (objectExists) {
			Travel travel = new Travel();
			BeanUtils.copyProperties(travelVo, travel);
			travelDao.save(travel);
		} else {
		}
	}

	@Override
	public void delete(Integer id) {
		Boolean objectExists = travelDao.existsById(id);
		if (objectExists) {
			travelDao.deleteById(id);
		} else {
		}
	}

	@Override
	public TravelVo get(Integer id) {
		Optional<Travel> travelOptional = travelDao.findById(id);
		TravelVo travelVo = null;
		if (travelOptional.isPresent()) {
			travelVo = new TravelVo();
			BeanUtils.copyProperties(travelOptional.get(), travelVo);
		} else {

		}

		return travelVo;
	}

	@Override
	public List<TravelVo> getAll() {
		List<Travel> travelList = travelDao.findAll();
		List<TravelVo> travelVoList = new ArrayList<>();
		if (travelList != null && !travelList.isEmpty()) {
			for (Travel travel : travelList) {
				TravelVo travelVo = new TravelVo();
				BeanUtils.copyProperties(travel, travelVo);
				travelVoList.add(travelVo);
			}
		}
		return travelVoList;
	}

}
