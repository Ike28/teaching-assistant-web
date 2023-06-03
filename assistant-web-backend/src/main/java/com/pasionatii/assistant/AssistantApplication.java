package com.pasionatii.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@CrossOrigin
@EntityScan(basePackages = "com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.repository")

public class AssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}

	@Bean(name = "properties")
	public Properties getProperties() {
		Properties properties = new Properties();

		try {
			properties.load(AssistantApplication.class.getResourceAsStream("/db.properties"));
		} catch (IOException ioException) {
			System.out.println("Cannot find db.properties! " + ioException.getMessage());
		}
		return properties;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/assistant/classes-javaconfig");
			}
		};
	}
}
