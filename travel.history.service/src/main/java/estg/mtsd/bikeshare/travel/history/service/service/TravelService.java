package estg.mtsd.bikeshare.travel.history.service.service;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.vo.TravelVo;

public interface TravelService {

    TravelVo save(TravelVo travelVo);

    void update(TravelVo travelVo);

    void delete(String id);

    TravelVo get(String id);

    List<TravelVo> getAll();

}
