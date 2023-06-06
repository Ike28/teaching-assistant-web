package com.pasionatii.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages = "com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.repository")
@ComponentScan("com.pasionatii.assistant.service")
@ComponentScan("com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.controller")
@CrossOrigin
public class AssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/assistant-javaconfig");
			}
		};
	}
}
