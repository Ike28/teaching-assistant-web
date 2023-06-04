package com.pasionatii.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EntityScan(basePackages = "com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.repository")
@ComponentScan("com.pasionatii.assistant.service")
@ComponentScan("com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.controller")
@EnableJpaRepositories(basePackages = "com.pasionatii.assistant")
@CrossOrigin
public class AssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}
}
