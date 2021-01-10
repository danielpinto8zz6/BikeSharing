package estg.mtsd.bikeshare.travel.history.service.service.impl;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.travel.history.service.dao.TravelEventDao;
import estg.mtsd.bikeshare.travel.history.service.entity.TravelEvent;
import estg.mtsd.bikeshare.travel.history.service.service.TravelEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TravelEventServiceImpl implements TravelEventService {

    @Autowired
    TravelEventDao travelEventDao;

    @Override
    public void save(TravelEventVo travelEventVo) {
        TravelEvent travelEvent = new TravelEvent();
        BeanUtils.copyProperties(travelEventVo, travelEvent);
        travelEventDao.save(travelEvent);
    }

    @Override
    public void delete(Integer rentalId) {
        boolean objectExists = travelEventDao.existsByRentalId(rentalId);
        if (objectExists) {
            travelEventDao.deleteByRentalId(rentalId);
        }
    }

    @Override
    public TravelEventVo get(Integer rentalId) {
        Optional<TravelEvent> travelEventOptional = travelEventDao.findByRentalId(rentalId);
        TravelEventVo travelEventVo = null;
        if (travelEventOptional.isPresent()) {
            travelEventVo = new TravelEventVo();
            BeanUtils.copyProperties(travelEventOptional.get(), travelEventVo);
        }

        return travelEventVo;
    }

    @Override
    public List<TravelEventVo> getAll() {
        List<TravelEvent> travelEventList = travelEventDao.findAll();
        List<TravelEventVo> travelEventVoList = new ArrayList<>();
        if (!travelEventList.isEmpty()) {
            for (TravelEvent travelEvent : travelEventList) {
                TravelEventVo travelEventVo = new TravelEventVo();
                BeanUtils.copyProperties(travelEvent, travelEventVo);
            }
        }
        return travelEventVoList;
    }
}
