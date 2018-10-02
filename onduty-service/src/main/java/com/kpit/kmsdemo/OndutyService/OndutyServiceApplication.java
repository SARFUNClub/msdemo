package com.kpit.kmsdemo.OndutyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
@EnableWebMvc
//@EnableCircuitBreaker
@SpringBootApplication
public class OndutyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OndutyServiceApplication.class, args);
	}
}
