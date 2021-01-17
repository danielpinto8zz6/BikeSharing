package estg.mtsd.bikeshare.token.manager.controller;

import estg.mtsd.bikeshare.token.manager.service.TokenService;
import estg.mtsd.bikeshare.token.manager.vo.EmailTokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("token")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@RequestBody EmailTokenVo emailTokenVo) {
        tokenService.save(emailTokenVo.getEmail(), emailTokenVo.getToken());
    }

    @GetMapping("token/{email}")
    public String get(@PathVariable String email) {
        return tokenService.findById(email);
    }

    @DeleteMapping("token/{email}")
    public void delete(@PathVariable String email) {
        tokenService.delete(email);
    }

}
