package estg.mtsd.bikeshare.travel.history.process.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import estg.mtsd.bikeshare.travel.history.process.service.entity.Travel;

@Repository
public interface TravelDao extends MongoRepository<Travel, Integer>{

}