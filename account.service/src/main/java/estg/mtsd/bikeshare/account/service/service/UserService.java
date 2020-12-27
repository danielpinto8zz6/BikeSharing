package estg.mtsd.bikeshare.account.service.service;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.models.UserVo;


public interface UserService {

	void save(UserVo userVo);

	void update(UserVo userVo);

	void delete(Integer id);

	UserVo get(Integer id);

	UserVo getByUsername(String username);

	List<UserVo> getAll();

}
