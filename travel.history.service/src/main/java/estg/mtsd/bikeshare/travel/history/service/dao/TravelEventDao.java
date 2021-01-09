package estg.mtsd.bikeshare.travel.history.service.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estg.mtsd.bikeshare.travel.history.service.entity.TravelEvent;

@Repository
public interface TravelEventDao extends MongoRepository<TravelEvent, String>{
    List<TravelEvent> findAllByTravelId(String travelId);
}
