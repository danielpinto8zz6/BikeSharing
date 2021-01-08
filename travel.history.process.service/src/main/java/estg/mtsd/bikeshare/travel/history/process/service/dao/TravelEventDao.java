package estg.mtsd.bikeshare.travel.history.process.service.dao;

import estg.mtsd.bikeshare.travel.history.process.service.entity.TravelEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelEventDao extends MongoRepository<TravelEvent, Integer>{

}
