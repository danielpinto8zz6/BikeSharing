package estg.mtsd.bikeshare.auth.service.service;

import estg.mtsd.bikeshare.shared.library.vo.UserVo;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallback implements AccountServiceProxy {

    @Override
    public UserVo getUserByUsername(String username) {
        return null;
    }

}
