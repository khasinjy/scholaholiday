package com.scholaholiday.scholaholiday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScholaholidayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScholaholidayApplication.class, args);

		Client client = new Client();
		Hebergement hebergement = new Hebergement();
		Reservation reservation = new Reservation();
	}

}
