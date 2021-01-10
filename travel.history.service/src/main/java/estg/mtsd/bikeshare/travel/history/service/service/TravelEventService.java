package estg.mtsd.bikeshare.travel.history.service.service;

import estg.mtsd.bikeshare.shared.library.vo.TravelEventVo;

import java.util.List;

public interface TravelEventService {

    void save(TravelEventVo travelEventVo);

    void delete(Integer rentalId);

    TravelEventVo get(Integer rentalId);

    List<TravelEventVo> getAll();

}
