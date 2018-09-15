package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class FlashcardHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardHystrixApplication.class, args);
	}
	
	@Bean //this works because @SpringBootApplication includes @Configuration
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
