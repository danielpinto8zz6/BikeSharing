package estg.mtsd.bikeshare.account.service.controller;

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

import estg.mtsd.bikeshare.account.service.service.UserService;
import estg.mtsd.bikeshare.account.service.vo.UserVo;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("user")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(UserVo userVo) {
		userService.save(userVo);
	}

	@GetMapping("user/{id}")
	public UserVo get( @PathVariable String id) {
		return userService.get(id);
	}

	@GetMapping("user")
	public List<UserVo>  getAll() {
		return userService.getAll();
	}
	
	@PutMapping("user")
	public void update(UserVo userVo) {
		userService.update(userVo);
	}
	
	@DeleteMapping("user/{id}")
	public void delete( @PathVariable String id) {
		userService.delete(id);
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
