package estg.mtsd.bikeshare.payment.calculator.service.service.impl;

import java.time.DateTimeException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.payment.calculator.service.service.PaymentCalculatorService;

@Service
public class PaymentCalculatorServiceImpl implements PaymentCalculatorService {

	private static final double PRICE_PER_MINUTE_IN_FIRST_15_MINUTES = 0.5;
	private static final double PRICE_PER_MINUTE_AFTER_15_MINUTES = 1;
	private static final int FIFTEEN_MINUTES_IN_SECONDS = 900;
	private static final int SECONDS_PER_MINUTE = 60;

	@Override
	public double calculate(Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			throw new DateTimeException("Start date can't be higher than end date");
		}

		long diff = endDate.getTime() - startDate.getTime();

		long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);

		if (seconds <= FIFTEEN_MINUTES_IN_SECONDS) {
			return (seconds / SECONDS_PER_MINUTE) * PRICE_PER_MINUTE_IN_FIRST_15_MINUTES;
		}

		return (15 * PRICE_PER_MINUTE_IN_FIRST_15_MINUTES)
				+ (((seconds - FIFTEEN_MINUTES_IN_SECONDS) / SECONDS_PER_MINUTE) * PRICE_PER_MINUTE_AFTER_15_MINUTES);
	}

}
