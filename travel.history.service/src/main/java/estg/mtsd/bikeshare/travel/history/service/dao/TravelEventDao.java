package estg.mtsd.bikeshare.travel.history.service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estg.mtsd.bikeshare.travel.history.service.entity.TravelEvent;

@Repository
public interface TravelEventDao extends MongoRepository<TravelEvent, Integer> {

    Optional<List<TravelEvent>> findAllByRentalId(Integer rentalId);

    boolean existsByRentalId(Integer rentalId);

    void deleteByRentalId(Integer rentalId);

}
