package com.tracktainment.reviewmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.tracktainment.bookmanager", "com.playground"})
@EnableJpaAuditing
@EnableFeignClients
public class ReviewManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewManagerApplication.class, args);
	}

}
