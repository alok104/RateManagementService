package com.rms.ratemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class RatemanagementserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatemanagementserviceApplication.class, args);
	}

}
