package estg.mtsd.bikeshare.notifications.service.repository.impl;

import estg.mtsd.bikeshare.notifications.service.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class TokenRepositoryImpl implements TokenRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOperations;

    // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public String findById(String email) {
        return (String) hashOperations.get("TOKEN", email);
    }

}