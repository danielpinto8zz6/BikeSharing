package estg.mtsd.bikeshare.payment.manager.service.service;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-calculator-service")
public interface PaymentCalculatorServiceProxy {

	@RequestMapping("/calculate")
	public double calculate(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate);
	
}