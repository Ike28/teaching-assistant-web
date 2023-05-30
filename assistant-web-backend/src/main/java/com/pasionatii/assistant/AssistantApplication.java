package com.pasionatii.assistant;

import com.pasionatii.assistant.repository.Implementation.RepoUser;
import com.pasionatii.assistant.repository.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class AssistantApplication {

	//public static void main(String[] args) {SpringApplication.run(AssistantApplication.class, args);	}
	public static void main(String[] args) {
		SessionFactoryProvider sessionFactoryProvider=new SessionFactoryProvider();
		SessionFactory sessionFactory=sessionFactoryProvider.getSessionFactory();
		RepoUser repoProfesor=new RepoUser(sessionFactory);

		repoProfesor.findAll();
		return;
	}

}
