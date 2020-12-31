package estg.mtsd.bikeshare.dock.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.dock.service.dao.DockDao;
import estg.mtsd.bikeshare.dock.service.entity.Dock;
import estg.mtsd.bikeshare.dock.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;

@Service
public class DockServiceImpl implements DockService {

	@Autowired
	DockDao dockDao;

	@Override
	public Boolean dockHasBike(Integer dockId, Integer bikeId) {
		Optional<Dock> dockOptional = dockDao.findById(dockId);
		if (dockOptional.isPresent()) {
			return dockOptional.get().getBikeId() == bikeId;
		}

		return false;
	}

	@Override
	@Transactional
	public void save(DockVo dockVo) {
		Dock dock = new Dock();
		BeanUtils.copyProperties(dockVo, dock);
		dockDao.save(dock);
	}

	@Override
	@Transactional
	public void update(DockVo dockVo) {
		Integer id = dockVo.getId();
		Boolean objectExists = dockDao.existsById(id);
		if (objectExists) {
			Dock dock = new Dock();
			BeanUtils.copyProperties(dockVo, dock);
			dockDao.save(dock);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists = dockDao.existsById(id);
		if (objectExists) {
			dockDao.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public DockVo get(Integer id) {
		Optional<Dock> dockOptional = dockDao.findById(id);
		DockVo dockVo = null;
		if (dockOptional.isPresent()) {
			dockVo = new DockVo();
			BeanUtils.copyProperties(dockOptional.get(), dockVo);
		} else {
			throw new EntityNotFoundException();
		}

		return dockVo;
	}

	@Override
	@Transactional
	public List<DockVo> getAll() {
		List<Dock> dockList = dockDao.findAll();
		List<DockVo> dockVoList = new ArrayList<>();
		if (dockList != null && !dockList.isEmpty()) {
			for (Dock dock : dockList) {
				DockVo dockVo = new DockVo();
				BeanUtils.copyProperties(dock, dockVo);
				dockVoList.add(dockVo);
			}
		}
		return dockVoList;
	}

	@Override
	public Page<DockVo> getAll(Pageable pageable) {
		Page<Dock> entities = dockDao.findAll(pageable);

		return entities.map(this::convertToDockVo);
	}

	@Override
	public Page<DockVo> getAllWithBikes(Pageable pageable) {
		Page<Dock> entities = dockDao.findByBikeIdNotNull(pageable);

		return entities.map(this::convertToDockVo);
	}

	private DockVo convertToDockVo(Dock entity) {
		DockVo dockVo = new DockVo();
		BeanUtils.copyProperties(entity, dockVo);

		return dockVo;
	}
}
