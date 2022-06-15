package ecommerce.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableEurekaClient
public class CandidatureServiceApplication {

	private static final Logger log = LogManager.getLogger(CandidatureServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CandidatureServiceApplication.class, args);
		log.info("application started");
		log.error("application started");
	}
}
