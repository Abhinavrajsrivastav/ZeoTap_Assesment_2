package com.example.abhinav.whether;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WhetherAppApplication {

	//Main or starting point of the application
	public static void main(String[] args) {
		SpringApplication.run(WhetherAppApplication.class, args);
	}

}
