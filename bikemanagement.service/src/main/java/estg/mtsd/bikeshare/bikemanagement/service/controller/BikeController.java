package estg.mtsd.bikeshare.bikemanagement.service.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import estg.mtsd.bikeshare.bikemanagement.service.service.BikeService;
import estg.mtsd.bikeshare.bikemanagement.service.vo.BikeVo;

@RestController
public class BikeController {

	@Autowired
	BikeService bikeService;

	@PostMapping("bike")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@RequestBody BikeVo bikeVo) {
		bikeService.save(bikeVo);
	}

	@GetMapping("bike/{id}")
	public BikeVo get( @PathVariable Integer id) {
		return bikeService.get(id);
	}

	@GetMapping("bike")
	public List<BikeVo>  getAll() {
		return bikeService.getAll();
	}
	
	@PutMapping("bike")
	public void update(@RequestBody BikeVo bikeVo) {
		bikeService.update(bikeVo);
	}
	
	@DeleteMapping("bike/{id}")
	public void delete( @PathVariable Integer id) {
		bikeService.delete(id);
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
