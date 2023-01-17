package com.barclays.movies;

import com.barclays.movies.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}
