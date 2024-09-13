package com.emazon.supply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmazonSupplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmazonSupplyApplication.class, args);
	}

}
