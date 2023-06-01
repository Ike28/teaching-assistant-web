package com.pasionatii.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EntityScan(basePackages = "com.pasionatii.assistant.entity")

public class AssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);	}


}
