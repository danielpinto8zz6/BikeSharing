package estg.mtsd.bikeshare.account.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.account.service.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{

}