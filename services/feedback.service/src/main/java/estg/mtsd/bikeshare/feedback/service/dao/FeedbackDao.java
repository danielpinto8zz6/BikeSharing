package estg.mtsd.bikeshare.feedback.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import estg.mtsd.bikeshare.feedback.service.entity.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

}