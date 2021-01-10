package estg.mtsd.bikeshare.rental.process.service.dao;

import estg.mtsd.bikeshare.rental.process.service.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentalDao extends JpaRepository<Rental, Integer> {
    List<Rental> findAllByBikeIdAndDateBetween(Integer bikeId, Date startDate, Date endDate);

    Optional<Rental> findByBikeId(Integer bikeId);
}