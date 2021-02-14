package estg.mtsd.bikeshare.dock.service.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import estg.mtsd.bikeshare.shared.library.vo.DockVo;

public interface DockService {

	Boolean dockHasBike(Integer dockId, Integer bikeId);

	void save(DockVo dockVo);

	void update(DockVo dockVo);

	void delete(Integer id);

	DockVo get(Integer id);

	List<DockVo> getAll();

	Page<DockVo> getAll(Pageable pageable);

	Page<DockVo> getAllWithBikes(Pageable pageable);

}
