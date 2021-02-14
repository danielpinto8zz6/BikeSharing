package estg.mtsd.bikeshare.bikemanagement.service.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import estg.mtsd.bikeshare.shared.library.vo.BikeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import estg.mtsd.bikeshare.bikemanagement.service.service.BikeService;

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
		BikeVo bikeVo = bikeService.get(id);
		bikeVo.setCode(null);

		return bikeVo;
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
