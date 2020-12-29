package estg.mtsd.bikeshare.feedback.service.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.feedback.service.service.FeedbackService;
import estg.mtsd.bikeshare.feedback.service.vo.FeedbackVo;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;

	@PostMapping("feedback")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(FeedbackVo feedbackVo) {
		feedbackService.save(feedbackVo);
	}

	@GetMapping("feedback/{id}")
	public FeedbackVo get( @PathVariable Integer id) {
		return feedbackService.get(id);
	}

	@GetMapping("feedback")
	public List<FeedbackVo>  getAll() {
		return feedbackService.getAll();
	}
	
	@PutMapping("feedback")
	public void update(FeedbackVo feedbackVo) {
		feedbackService.update(feedbackVo);
	}
	
	@DeleteMapping("feedback/{id}")
	public void delete( @PathVariable Integer id) {
		feedbackService.delete(id);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleEntityExistsException(EntityExistsException e) {
	    return e.getMessage();
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
	    return e.getMessage();
	}
}
