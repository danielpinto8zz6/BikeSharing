package estg.mtsd.bikeshare.token.manager.service.impl;

import estg.mtsd.bikeshare.token.manager.repository.TokenRepository;
import estg.mtsd.bikeshare.token.manager.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public void save(String email, String token) {
        tokenRepository.save(email, token);
    }

    @Override
    public Map<String, String> findAll() {
        return tokenRepository.findAll();
    }

    @Override
    public String findById(String email) {
        return tokenRepository.findById(email);
    }

    @Override
    public void update(String email, String token) {
        tokenRepository.update(email, token);
    }

    @Override
    public void delete(String email) {
        tokenRepository.delete(email);
    }
}

