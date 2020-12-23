package estg.mtsd.bikeshare.account.service.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.account.service.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}