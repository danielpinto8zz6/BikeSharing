package estg.mtsd.bikeshare.dockmanagement.service.service;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.vo.DockVo;

public interface DockService {

	Boolean dockHasBike(Integer dockId, Integer bikeId);

	void save(DockVo dockVo);

	void update(DockVo dockVo);

	void delete(Integer id);

	DockVo get(Integer id);

	List<DockVo> getAll();

}
