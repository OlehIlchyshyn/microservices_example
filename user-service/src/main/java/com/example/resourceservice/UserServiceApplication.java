package com.example.resourceservice;

import com.example.resourceservice.entities.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
