package estg.mtsd.bikeshare.rent.service.service;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.vo.RentVo;


public interface RentService {

	void rent(RentVo rentVo) throws Exception ;
	void update(RentVo rentVo) ;
	void delete(Integer id);
	RentVo get(Integer id);
	List<RentVo> getAll();

}
