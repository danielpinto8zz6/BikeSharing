package estg.mtsd.bikeshare.travel.history.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.shared.library.vo.TravelVo;
import estg.mtsd.bikeshare.travel.history.service.entity.Travel;
import estg.mtsd.bikeshare.travel.history.service.entity.TravelEvent;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.travel.history.service.dao.TravelDao;
import estg.mtsd.bikeshare.travel.history.service.dao.TravelEventDao;
import estg.mtsd.bikeshare.travel.history.service.service.TravelService;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	TravelDao travelDao;

	@Autowired
	TravelEventDao travelEventDao;

	@Override
	public TravelVo save(TravelVo travelVo) {
		Travel travel = new Travel();
		BeanUtils.copyProperties(travelVo, travel);
		Travel travelEntity = travelDao.save(travel);
		BeanUtils.copyProperties(travelEntity, travelVo);
		
		return travelVo;
	}

	@Override
	public void update(TravelVo travelVo) {
		String id = travelVo.getId();
		boolean objectExists = travelDao.existsById(id);
		if (objectExists) {
			Travel travel = new Travel();
			BeanUtils.copyProperties(travelVo, travel);
			travelDao.save(travel);
		}
	}

	@Override
	public void delete(String id) {
		boolean objectExists = travelDao.existsById(id);
		if (objectExists) {
			travelDao.deleteById(id);
		}
	}

	@Override
	public TravelVo get(String id) {
		Optional<Travel> travelOptional = travelDao.findById(id);
		TravelVo travelVo = null;
		if (travelOptional.isPresent()) {
			travelVo = new TravelVo();
			BeanUtils.copyProperties(travelOptional.get(), travelVo);

			List<TravelEvent> travelEvents = travelEventDao.findAllByTravelId(travelVo.getId());

			List<TravelEventVo> travelEventsVo = travelEvents.stream().map(this::convertToTravelEventVo)
					.collect(Collectors.toList());

			travelVo.setGps(travelEventsVo);
		}

		return travelVo;
	}

	@Override
	public List<TravelVo> getAll() {
		List<Travel> travelList = travelDao.findAll();
		List<TravelVo> travelVoList = new ArrayList<>();
		if (!travelList.isEmpty()) {
			for (Travel travel : travelList) {
				TravelVo travelVo = new TravelVo();
				BeanUtils.copyProperties(travel, travelVo);

				List<TravelEvent> travelEvents = travelEventDao.findAllByTravelId(travelVo.getId());

				List<TravelEventVo> travelEventsVo = travelEvents.stream().map(this::convertToTravelEventVo)
						.collect(Collectors.toList());

				travelVo.setGps(travelEventsVo);

				travelVoList.add(travelVo);
			}
		}
		return travelVoList;
	}

	private TravelEventVo convertToTravelEventVo(TravelEvent entity) {
		TravelEventVo travelEventVo = new TravelEventVo();
		BeanUtils.copyProperties(entity, travelEventVo);

		return travelEventVo;
	}

}
