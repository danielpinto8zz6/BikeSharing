package estg.mtsd.bikeshare.notifications.service.service.impl;

import estg.mtsd.bikeshare.notifications.service.repository.TokenRepository;
import estg.mtsd.bikeshare.notifications.service.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public String findById(String email) {
        return tokenRepository.findById(email);
    }

}

