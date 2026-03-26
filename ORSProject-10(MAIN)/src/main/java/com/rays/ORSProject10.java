package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class of ORS Project.
 * 
 * This class starts the Spring Boot application and configures CORS and
 * Interceptor settings.
 * 
 * @author Amit
 */
@SpringBootApplication
public class ORSProject10 {

	/**
	 * Main method to run the Spring Boot application.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(ORSProject10.class, args);

	}

	/**
	 * Configure CORS and Interceptor for the application.
	 * 
	 * @return WebMvcConfigurer object
	 */
	@Bean
	public WebMvcConfigurer corsConfig() {

		return new WebMvcConfigurer() {

			/**
			 * Allow cross origin requests from Angular application.
			 */
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**").allowedOrigins("http://localhost:8081").allowedMethods("*")
						.allowedHeaders("*").allowCredentials(true);
			}

		};
	}
}