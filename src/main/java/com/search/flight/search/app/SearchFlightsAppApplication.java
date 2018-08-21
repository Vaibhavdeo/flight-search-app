package com.search.flight.search.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SearchFlightsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchFlightsAppApplication.class, args);
	}
}
