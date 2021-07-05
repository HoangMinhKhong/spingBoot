package com.vnpay.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.vnpay"})
public class ManagermentWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagermentWebServiceApplication.class, args);
	}

}
