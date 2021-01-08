package estg.mtsd.bikeshare.travel.history.receiver.service.dao;

import estg.mtsd.bikeshare.travel.history.receiver.service.entity.TravelEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelEventDao extends MongoRepository<TravelEvent, Integer>{

}
