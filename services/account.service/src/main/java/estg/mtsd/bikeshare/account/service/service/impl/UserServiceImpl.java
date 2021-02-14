package estg.mtsd.bikeshare.account.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.account.service.dao.UserDao;
import estg.mtsd.bikeshare.account.service.entity.User;
import estg.mtsd.bikeshare.account.service.service.UserService;
import estg.mtsd.bikeshare.shared.library.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public void save(UserVo userVo) {
        String username = userVo.getUsername();

        Boolean userAlreadyExists = userDao.existsByUsername(username);
        if (!userAlreadyExists) {
            User user = new User();
            BeanUtils.copyProperties(userVo, user);

            user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
            user.setRole("USER");

            userDao.save(user);
        } else {
            throw new EntityExistsException();
        }

    }

    @Override
    @Transactional
    public void update(UserVo userVo) {
        Integer id = userVo.getId();
        Optional<User> userOptional = userDao.findById(id);
        if (userOptional.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userVo, user);

            user.setPassword(userOptional.get().getPassword());

            userDao.save(user);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void updatePassword(UserVo userVo) {
        Integer id = userVo.getId();
        Optional<User> userOptional = userDao.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(bCryptPasswordEncoder().encode(userVo.getPassword()));

            userDao.save(user);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Boolean objectExists = userDao.existsById(id);
        if (objectExists) {
            userDao.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public UserVo get(Integer id) {
        Optional<User> userOptional = userDao.findById(id);
        UserVo userVo = null;
        if (userOptional.isPresent()) {
            userVo = new UserVo();
            BeanUtils.copyProperties(userOptional.get(), userVo);
            userVo.setPassword(null);
        } else {
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
                userVo.setPassword(null);
                userVoList.add(userVo);
            }
        }
        return userVoList;
    }

    @Override
    public UserVo getByUsername(String username) {
        Optional<User> userOptional = userDao.findByUsername(username);
        UserVo userVo = null;
        if (userOptional.isPresent()) {
            userVo = new UserVo();
            BeanUtils.copyProperties(userOptional.get(), userVo);
        } else {
            throw new EntityNotFoundException();
        }

        return userVo;
    }
}
