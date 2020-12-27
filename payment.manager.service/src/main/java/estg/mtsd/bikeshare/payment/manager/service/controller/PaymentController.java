package estg.mtsd.bikeshare.payment.manager.service.controller;

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

import estg.mtsd.bikeshare.payment.manager.service.service.PaymentService;
import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentRequest;
import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentVo;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("payment")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void generate(PaymentRequest paymentRequest) {
		paymentService.generate(paymentRequest);
	}

	@GetMapping("payment/{id}")
	public PaymentVo get( @PathVariable Integer id) {
		return paymentService.get(id);
	}

	@GetMapping("payment")
	public List<PaymentVo>  getAll() {
		return paymentService.getAll();
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
