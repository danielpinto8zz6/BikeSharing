package estg.mtsd.bikeshare.payment.service.controller;

import estg.mtsd.bikeshare.payment.service.service.PaymentService;
import estg.mtsd.bikeshare.shared.library.utils.JsonUtils;
import estg.mtsd.bikeshare.shared.library.utils.JwtUtils;
import estg.mtsd.bikeshare.shared.library.vo.PaymentDataVo;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PaymentController {

	@Autowired
    PaymentService paymentService;

	@PostMapping("payment")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(PaymentDataVo paymentDataVo) {
		paymentService.save(paymentDataVo);
	}

	@GetMapping("payment/{id}")
	public PaymentVo get( @PathVariable Integer id) {
		return paymentService.get(id);
	}

	@GetMapping("payment")
	public List<PaymentVo> getAll(@RequestHeader("Authorization") String token)
	{
		String email = JwtUtils.parseUserEmail(token);

		return paymentService.getAll(email);
	}
	
	@PutMapping("payment")
	public void update(PaymentVo paymentVo) {
		paymentService.update(paymentVo);
	}
	
	@DeleteMapping("payment/{id}")
	public void delete( @PathVariable Integer id) {
		paymentService.delete(id);
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
