package ecommerce.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CandidatureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatureServiceApplication.class, args);
	}
}
