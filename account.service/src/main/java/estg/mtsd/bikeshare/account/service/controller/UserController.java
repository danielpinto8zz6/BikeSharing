package estg.mtsd.bikeshare.account.service.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.account.service.service.UserService;
import estg.mtsd.bikeshare.shared.library.vo.UserVo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void save(@RequestBody UserVo userVo) {
		userService.save(userVo);
	}

	@RequestMapping("/{email}")
	public UserVo get(@PathVariable String email) {
		return userService.getByUsername(email);
	}

	@RequestMapping()
	public List<UserVo> getAll() {
		return userService.getAll();
	}

	@PutMapping()
	public void update(@RequestBody UserVo userVo) {
		userService.update(userVo);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
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
