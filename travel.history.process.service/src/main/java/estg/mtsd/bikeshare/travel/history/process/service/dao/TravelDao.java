package estg.mtsd.bikeshare.travel.history.process.service.dao;

import estg.mtsd.bikeshare.travel.history.process.service.entity.Travel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelDao extends MongoRepository<Travel, Integer> {

}