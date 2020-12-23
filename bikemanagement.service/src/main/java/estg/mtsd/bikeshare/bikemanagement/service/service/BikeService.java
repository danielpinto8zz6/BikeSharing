package estg.mtsd.bikeshare.bikemanagement.service.service;

import java.util.List;

import estg.mtsd.bikeshare.bikemanagement.service.vo.BikeVo;

public interface BikeService {

	void save(BikeVo bikeVo) ;
	void update(BikeVo bikeVo) ;
	void delete(Integer id);
	BikeVo get(Integer id);
	List<BikeVo> getAll();

}

