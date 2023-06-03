package com.pasionatii.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan(basePackages = "com.pasionatii.assistant.entity")
@ComponentScan("com.pasionatii.assistant.repository")
@CrossOrigin
public class AssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}
}
