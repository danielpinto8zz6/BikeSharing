package estg.mtsd.bikeshare.travel.history.service.controller;

import java.util.List;

import estg.mtsd.bikeshare.shared.library.vo.TravelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.travel.history.service.service.TravelService;

@RestController
public class TravelController {

	@Autowired
	TravelService travelService;

	@PostMapping("travel")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(@RequestBody TravelVo travelVo) {
		travelService.save(travelVo);
	}

	@GetMapping("travel/{id}")
	public TravelVo get( @PathVariable String id) {
		return travelService.get(id);
	}

	@GetMapping("travel")
	public List<TravelVo>  getAll() {
		return travelService.getAll();
	}
	
	@PutMapping("travel")
	public void update(TravelVo travelVo) {
		travelService.update(travelVo);
	}
	
	@DeleteMapping("travel/{id}")
	public void delete( @PathVariable String id) {
		travelService.delete(id);
	}

}
