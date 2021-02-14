package estg.mtsd.bikeshare.auth.service.service;

import estg.mtsd.bikeshare.shared.library.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-service", fallback = AccountServiceFallback.class)
public interface AccountServiceProxy {

    @RequestMapping("/user/{username}")
    UserVo getUserByUsername(@PathVariable("username") String username);

}