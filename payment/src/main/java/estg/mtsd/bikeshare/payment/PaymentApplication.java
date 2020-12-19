package estg.mtsd.bikeshare.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 		// It acts as a eureka client
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}
