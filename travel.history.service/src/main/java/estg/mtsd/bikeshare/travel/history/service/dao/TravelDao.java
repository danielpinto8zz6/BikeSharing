package estg.mtsd.bikeshare.travel.history.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.travel.history.service.entity.Travel;

@Repository
public interface TravelDao extends MongoRepository<Travel, String>{

}