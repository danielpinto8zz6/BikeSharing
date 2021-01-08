package estg.mtsd.bikeshare.travel.history.process.service.service.impl;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.travel.history.process.service.dao.TravelEventDao;
import estg.mtsd.bikeshare.travel.history.process.service.entity.TravelEvent;
import estg.mtsd.bikeshare.travel.history.process.service.service.TravelEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<TravelEventVo> getAll() {
        List<TravelEvent> travelEventList = travelEventDao.findAll();
        List<TravelEventVo> travelEventVoList = new ArrayList<>();
        if (!travelEventList.isEmpty()) {
            for (TravelEvent travelEvent : travelEventList) {
                TravelEventVo travelEventVo = new TravelEventVo();
                BeanUtils.copyProperties(travelEvent, travelEventVo);
                travelEventVoList.add(travelEventVo);
            }
        }
        return travelEventVoList;
    }

}

