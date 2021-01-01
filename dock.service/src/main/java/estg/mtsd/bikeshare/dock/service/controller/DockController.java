package estg.mtsd.bikeshare.dock.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.dock.service.service.DockService;
import estg.mtsd.bikeshare.shared.library.vo.DockVo;

@RestController
public class DockController {

	@Autowired
	DockService dockService;

	@GetMapping("hasBike")
	public Boolean dockHasBike(@RequestParam("dockId") Integer dockId, @RequestParam("bikeId") Integer bikeId) {
		return dockService.dockHasBike(dockId, bikeId);

	}

	@PostMapping("dock")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@RequestBody DockVo dockVo) {
		dockService.save(dockVo);
	}

	@GetMapping("dock/{id}")
	public DockVo get(@PathVariable Integer id) {
		return dockService.get(id);
	}

	@GetMapping("dock")
	public Page<DockVo> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "false") Boolean onlyWithBikes) {
		PageRequest paging = PageRequest.of(page, size);

		if (onlyWithBikes) {
			return dockService.getAllWithBikes(paging);
		}

		return dockService.getAll(paging);
	}

	@PutMapping("dock")
	public void update(DockVo dockVo) {
		dockService.update(dockVo);
	}

	@DeleteMapping("dock/{id}")
	public void delete(@PathVariable Integer id) {
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
