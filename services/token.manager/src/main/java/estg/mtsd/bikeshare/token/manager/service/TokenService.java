package estg.mtsd.bikeshare.token.manager.service;

import java.util.Map;

public interface TokenService {

    void save(String email, String token);

    Map<String, String> findAll();

    String findById(String email);

    void update(String email, String token);

    void delete(String email);

}

