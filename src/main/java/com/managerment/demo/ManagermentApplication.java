package com.managerment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.managerment"})
public class ManagermentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagermentApplication.class, args);
	}
}
