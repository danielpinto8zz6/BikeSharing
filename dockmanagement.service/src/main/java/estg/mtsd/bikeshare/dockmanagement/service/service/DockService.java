package estg.mtsd.bikeshare.dockmanagement.service.service;

import java.util.List;

import estg.mtsd.bikeshare.dockmanagement.service.vo.DockVo;

public interface DockService {

	void save(DockVo dockVo) ;
	void update(DockVo dockVo) ;
	void delete(Integer id);
	DockVo get(Integer id);
	List<DockVo> getAll();

}

