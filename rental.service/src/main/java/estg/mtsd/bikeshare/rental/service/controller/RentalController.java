package estg.mtsd.bikeshare.rental.service.controller;

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

import estg.mtsd.bikeshare.rental.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;

@RestController
public class RentalController {

	@Autowired
    RentalService rentalService;

	@PostMapping("rental")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void rental(@RequestBody RentalVo rentalVo) throws Exception {
		rentalService.rental(rentalVo);
	}

	@GetMapping("rental/{id}")
	public RentalVo get(@PathVariable Integer id) {
		return rentalService.get(id);
	}

	@GetMapping("rental")
	public List<RentalVo>  getAll() {
		return rentalService.getAll();
	}
	
	@PutMapping("rental")
	public void update(RentalVo rentalVo) {
		rentalService.update(rentalVo);
	}
	
	@DeleteMapping("rental/{id}")
	public void delete( @PathVariable Integer id) {
		rentalService.delete(id);
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
