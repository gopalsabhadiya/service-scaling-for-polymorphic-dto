package com.taapti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Dynamic Type Resolution application.
 * This class contains the main method which serves as the entry point for the Spring Boot application.
 */
@SpringBootApplication
public class Application {

	/**
	 * The main method which serves as the entry point for the Spring Boot application.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
