package estg.mtsd.bikeshare.token.manager.repository;

import java.util.Map;

public interface TokenRepository {

    void save(String email, String token);

    Map<String, String> findAll();

    String findById(String email);

    void update(String email, String token);

    void delete(String email);

}
