package estg.mtsd.bikeshare.travel.history.process.service.service;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;

import java.util.List;

public interface TravelEventService {

    void save(TravelEventVo travelVo);

    List<TravelEventVo> getAll();

}
