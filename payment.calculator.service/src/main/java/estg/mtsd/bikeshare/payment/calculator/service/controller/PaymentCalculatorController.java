package estg.mtsd.bikeshare.payment.calculator.service.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import estg.mtsd.bikeshare.payment.calculator.service.service.PaymentCalculatorService;

@RestController
public class PaymentCalculatorController {

	@Autowired
	PaymentCalculatorService paymentCalculatorService;

	@GetMapping("calculate")
	public double calculate(@RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endDate) {
		return paymentCalculatorService.calculate(startDate, endDate);
	}
}
