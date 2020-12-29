package estg.mtsd.bikeshare.dockmanagement.service.controller;

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

import estg.mtsd.bikeshare.dockmanagement.service.service.DockService;
import estg.mtsd.bikeshare.dockmanagement.service.vo.DockVo;

@RestController
public class DockController {

	@Autowired
	DockService dockService;

	@PostMapping("dock")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(DockVo dockVo) {
		dockService.save(dockVo);
	}

	@GetMapping("dock/{id}")
	public DockVo get( @PathVariable Integer id) {
		return dockService.get(id);
	}

	@GetMapping("dock")
	public List<DockVo>  getAll() {
		return dockService.getAll();
	}
	
	@PutMapping("dock")
	public void update(DockVo dockVo) {
		dockService.update(dockVo);
	}
	
	@DeleteMapping("dock/{id}")
	public void delete( @PathVariable Integer id) {
		dockService.delete(id);
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
