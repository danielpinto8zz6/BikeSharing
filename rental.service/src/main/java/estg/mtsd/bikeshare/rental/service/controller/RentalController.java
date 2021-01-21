package estg.mtsd.bikeshare.rental.service.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import estg.mtsd.bikeshare.shared.library.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import estg.mtsd.bikeshare.rental.service.service.RentalService;
import estg.mtsd.bikeshare.shared.library.vo.RentalVo;

@RestController
public class RentalController {

	@Autowired
    RentalService rentalService;

	@PostMapping("rental")
	@ResponseStatus(value = HttpStatus.CREATED)
	public RentalVo rental(@RequestBody RentalVo rentalVo) throws Exception {
		return rentalService.rental(rentalVo);
	}

	@GetMapping("rental/{id}")
	public RentalVo get(@PathVariable Integer id) {
		return rentalService.get(id);
	}

	@GetMapping("rental")
	public List<RentalVo>  getAll(@RequestHeader("Authorization") String token) {
		String email = JwtUtils.parseUserEmail(token);
		return rentalService.getAll(email);
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
