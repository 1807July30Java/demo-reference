package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.revature.filter.SimplePreFilter;

@SpringBootApplication
@EnableZuulProxy
public class FlashcardGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardGatewayApplication.class, args);
	}
	
	//what our bean definitions look like with Java-based config.
	@Bean
	public SimplePreFilter simplePreFilter() {
		return new SimplePreFilter();
	}
}
