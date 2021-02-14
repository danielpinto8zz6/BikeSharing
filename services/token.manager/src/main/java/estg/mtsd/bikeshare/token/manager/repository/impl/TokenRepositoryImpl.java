package estg.mtsd.bikeshare.token.manager.repository.impl;

import estg.mtsd.bikeshare.token.manager.repository.TokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

import javax.annotation.PostConstruct;

@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private HashOperations<String, String, String> hashOperations;

    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String email, String token) {
        hashOperations.put("TOKEN", email, token);
    }

    @Override
    public Map<String, String> findAll() {
        return hashOperations.entries("TOKEN");
    }

    @Override
    public String findById(String email) {
        return (String) hashOperations.get("TOKEN", email);
    }

    @Override
    public void update(String email, String token) {
        save(email, token);
    }

    @Override
    public void delete(String email) {
        hashOperations.delete("TOKEN", email);
    }
}