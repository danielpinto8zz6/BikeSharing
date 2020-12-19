package estg.mtsd.bikeshare.account.service.service;

import java.util.List;

import estg.mtsd.bikeshare.account.service.vo.UserVo;

public interface UserService {

	void save(UserVo userVo) ;
	void update(UserVo userVo) ;
	void delete(String id);
	UserVo get(String id);
	List<UserVo> getAll();

}

