package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FlashcardGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardGatewayApplication.class, args);
	}
}
