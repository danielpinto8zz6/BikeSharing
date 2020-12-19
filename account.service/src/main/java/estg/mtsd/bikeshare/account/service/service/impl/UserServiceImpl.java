package estg.mtsd.bikeshare.account.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.account.service.dao.UserDao;
import estg.mtsd.bikeshare.account.service.entity.User;
import estg.mtsd.bikeshare.account.service.service.UserService;
import estg.mtsd.bikeshare.account.service.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public void save(UserVo userVo) {	
		String id = userVo.getId();
		Boolean objectAlreadyExists=userDao.existsById(id);
		if(!objectAlreadyExists) {
			User user = new User();
			BeanUtils.copyProperties(userVo, user);
			userDao.save(user);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(UserVo userVo) {
		String id = userVo.getId();
		Boolean objectExists=userDao.existsById(id);
		if(objectExists) {
			User user = new User();
			BeanUtils.copyProperties(userVo, user);
			userDao.save(user);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(String id) {
		Boolean objectExists=userDao.existsById(id);
		if(objectExists) {
			userDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public UserVo get(String id) {
		Optional<User> userOptional = userDao.findById(id);
		UserVo userVo=null;
		if(userOptional.isPresent()) {
			userVo = new UserVo();
			BeanUtils.copyProperties(userOptional.get(), userVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return userVo;
	}

	@Override
	@Transactional
	public List<UserVo> getAll() {
		List<User> userList = userDao.findAll();
		List<UserVo> userVoList = new ArrayList<>();
		if (userList != null && !userList.isEmpty()) {
			for (User user : userList) {
				UserVo userVo = new UserVo();
				BeanUtils.copyProperties(user, userVo);
				userVoList.add(userVo);
			}
		}
		return userVoList;
	}

}

