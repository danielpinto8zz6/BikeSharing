package estg.mtsd.bikeshare.travel.history.receiver.service.service.impl;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;
import estg.mtsd.bikeshare.travel.history.receiver.service.producers.TravelEventProducer;
import estg.mtsd.bikeshare.travel.history.receiver.service.service.TravelEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelEventServiceImpl implements TravelEventService {

    @Autowired
    TravelEventProducer travelEventProducer;

    @Override
    public void save(TravelEventVo travelEventVo) {
        travelEventProducer.send(travelEventVo);
    }
}
