package estg.mtsd.bikeshare.token.manager.repository.impl;

import estg.mtsd.bikeshare.token.manager.repository.TokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private HashOperations hashOperations;

    @Override
    public void save(String email, String token) {
        hashOperations.put("token", email, token);
    }

    @Override
    public Map<String, String> findAll() {
        return hashOperations.entries("token");
    }

    @Override
    public String findById(String email) {
        return (String) hashOperations.get("token", email);
    }

    @Override
    public void update(String email, String token) {
        save(email, token);
    }

    @Override
    public void delete(String email) {
        hashOperations.delete("token", email);
    }
}