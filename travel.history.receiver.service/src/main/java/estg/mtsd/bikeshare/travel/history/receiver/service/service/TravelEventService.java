package estg.mtsd.bikeshare.travel.history.receiver.service.service;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;

import java.util.List;

public interface TravelEventService {

    void save(TravelEventVo travelVo);

    List<TravelEventVo> getAll();

}
