package estg.mtsd.bikeshare.feedback.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.feedback.service.dao.FeedbackDao;
import estg.mtsd.bikeshare.feedback.service.entity.Feedback;
import estg.mtsd.bikeshare.feedback.service.service.FeedbackService;
import estg.mtsd.bikeshare.feedback.service.vo.FeedbackVo;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao feedbackDao;

	@Override
	@Transactional
	public void save(FeedbackVo feedbackVo) {	
		Integer id = feedbackVo.getId();
		Boolean objectAlreadyExists=feedbackDao.existsById(id);
		if(!objectAlreadyExists) {
			Feedback feedback = new Feedback();
			BeanUtils.copyProperties(feedbackVo, feedback);
			feedbackDao.save(feedback);
		}else {
			throw new EntityExistsException();
		}
		
	}
	
	@Override
	@Transactional
	public void update(FeedbackVo feedbackVo) {
		Integer id = feedbackVo.getId();
		Boolean objectExists=feedbackDao.existsById(id);
		if(objectExists) {
			Feedback feedback = new Feedback();
			BeanUtils.copyProperties(feedbackVo, feedback);
			feedbackDao.save(feedback);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=feedbackDao.existsById(id);
		if(objectExists) {
			feedbackDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public FeedbackVo get(Integer id) {
		Optional<Feedback> feedbackOptional = feedbackDao.findById(id);
		FeedbackVo feedbackVo=null;
		if(feedbackOptional.isPresent()) {
			feedbackVo = new FeedbackVo();
			BeanUtils.copyProperties(feedbackOptional.get(), feedbackVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return feedbackVo;
	}

	@Override
	@Transactional
	public List<FeedbackVo> getAll() {
		List<Feedback> feedbackList = feedbackDao.findAll();
		List<FeedbackVo> feedbackVoList = new ArrayList<>();
		if (feedbackList != null && !feedbackList.isEmpty()) {
			for (Feedback feedback : feedbackList) {
				FeedbackVo feedbackVo = new FeedbackVo();
				BeanUtils.copyProperties(feedback, feedbackVo);
				feedbackVoList.add(feedbackVo);
			}
		}
		return feedbackVoList;
	}

}

