package estg.mtsd.bikeshare.dockmanagement.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.dockmanagement.service.dao.DockDao;
import estg.mtsd.bikeshare.dockmanagement.service.entity.Dock;
import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.dockmanagement.service.vo.DockVo;

@Service
public class DockServiceImpl implements DockService {

	@Autowired
	DockDao dockDao;

	@Override
	@Transactional
	public void save(DockVo dockVo) {	
		Integer id = dockVo.getId();
		Boolean objectAlreadyExists=dockDao.existsById(id);
		if(!objectAlreadyExists) {
			Dock dock = new Dock();
			BeanUtils.copyProperties(dockVo, dock);
			dockDao.save(dock);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(DockVo dockVo) {
		Integer id = dockVo.getId();
		Boolean objectExists=dockDao.existsById(id);
		if(objectExists) {
			Dock dock = new Dock();
			BeanUtils.copyProperties(dockVo, dock);
			dockDao.save(dock);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=dockDao.existsById(id);
		if(objectExists) {
			dockDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public DockVo get(Integer id) {
		Optional<Dock> dockOptional = dockDao.findById(id);
		DockVo dockVo=null;
		if(dockOptional.isPresent()) {
			dockVo = new DockVo();
			BeanUtils.copyProperties(dockOptional.get(), dockVo);	
		}else {
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

}

