package com.tailoredleisure.webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.tailoredleisure.webportal.entity")
public class WebportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebportalApplication.class, args);
	}

}
