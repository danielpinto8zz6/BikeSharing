package estg.mtsd.bikeshare.auth.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import estg.mtsd.bikeshare.shared.library.models.UserVo;

@FeignClient(name = "account-service") // Service Id of account service
public interface AccountServiceProxy {
	
	 @RequestMapping("/user/{username}")
	 public UserVo getUserByUsername(@PathVariable("username") String username);

}