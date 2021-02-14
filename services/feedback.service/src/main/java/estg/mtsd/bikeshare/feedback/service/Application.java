package estg.mtsd.bikeshare.feedback.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 		// It acts as a eureka client
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
