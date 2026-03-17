package com.CRONMultDBOnProducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CronMultDbOnProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CronMultDbOnProductsApplication.class, args);
	}

}
