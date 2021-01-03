package estg.mtsd.bikeshare.rent.service.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.rent.service.service.RentService;
import estg.mtsd.bikeshare.rent.service.vo.RentVo;

@RestController
public class RentController {

	@Autowired
	RentService rentService;

	@PostMapping("rent")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@RequestBody RentVo rentVo) throws Exception {
		rentService.save(rentVo);
	}

	@GetMapping("rent/{id}")
	public RentVo get( @PathVariable Integer id) {
		return rentService.get(id);
	}

	@GetMapping("rent")
	public List<RentVo>  getAll() {
		return rentService.getAll();
	}
	
	@PutMapping("rent")
	public void update(RentVo rentVo) {
		rentService.update(rentVo);
	}
	
	@DeleteMapping("rent/{id}")
	public void delete( @PathVariable Integer id) {
		rentService.delete(id);
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
