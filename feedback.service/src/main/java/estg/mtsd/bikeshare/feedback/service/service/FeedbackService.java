package estg.mtsd.bikeshare.feedback.service.service;

import java.util.List;

import estg.mtsd.bikeshare.feedback.service.vo.FeedbackVo;

public interface FeedbackService {

	void save(FeedbackVo feedbackVo) ;
	void update(FeedbackVo feedbackVo) ;
	void delete(Integer id);
	FeedbackVo get(Integer id);
	List<FeedbackVo> getAll();

}

