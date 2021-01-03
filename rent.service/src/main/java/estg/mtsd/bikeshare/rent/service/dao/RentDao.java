package estg.mtsd.bikeshare.rent.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.rent.service.entity.Rent;

@Repository
public interface RentDao extends JpaRepository<Rent, Integer> {
    List<Rent> findAllByBikeIdAndDateBetween(Integer bikeId, Date startDate, Date endDate);
}