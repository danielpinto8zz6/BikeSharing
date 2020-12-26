package estg.mtsd.bikeshare.travel.history.service.service;

import java.util.List;

import estg.mtsd.bikeshare.travel.history.service.vo.TravelVo;

public interface TravelService {

	void save(TravelVo travelVo) ;
	void update(TravelVo travelVo) ;
	void delete(Integer id);
	TravelVo get(Integer id);
	List<TravelVo> getAll();

}

