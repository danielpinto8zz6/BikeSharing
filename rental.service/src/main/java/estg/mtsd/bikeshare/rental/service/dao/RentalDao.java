package estg.mtsd.bikeshare.rental.service.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.rental.service.entity.Rental;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer> {
    List<Rental> findAllByBikeIdAndStartDateBetween(Integer bikeId, Date startDate, Date endDate);
}