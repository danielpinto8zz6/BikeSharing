package estg.mtsd.bikeshare.bike.validator.service.dao;

import estg.mtsd.bikeshare.bike.validator.service.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeDao extends JpaRepository<Bike, Integer> {

}