package estg.mtsd.bikeshare.bikemanagement.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.bikemanagement.service.entity.Bike;

@Repository
public interface BikeDao extends JpaRepository<Bike, Integer>{

}