package estg.mtsd.bikeshare.payment.calculator.service.service.impl;

import java.time.DateTimeException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.payment.calculator.service.service.PaymentCalculatorService;

@Service
public class PaymentCalculatorServiceImpl implements PaymentCalculatorService {

	private static final double PRICE_PER_MINUTE_IN_FIRST_15_MINUTES = 0.5;
	private static final double PRICE_PER_MINUTE_AFTER_15_MINUTES = 0.1;

	@Override
	public double calculate(Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			throw new DateTimeException("Start date can't be higher than end date");
		}

		long diff = endDate.getTime() - startDate.getTime();

		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

		if (minutes <= 15) {
			return minutes * PRICE_PER_MINUTE_IN_FIRST_15_MINUTES;
		}

		return (15 * PRICE_PER_MINUTE_IN_FIRST_15_MINUTES) + ((minutes - 15) * PRICE_PER_MINUTE_AFTER_15_MINUTES);
	}

}
