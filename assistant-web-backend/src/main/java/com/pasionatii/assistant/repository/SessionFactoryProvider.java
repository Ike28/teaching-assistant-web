package com.pasionatii.assistant.repository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }

    private static void buildSessionFactory() {
        try {
            Properties properties = new Properties();
            try (InputStream inputStream = SessionFactoryProvider.class.getClassLoader().getResourceAsStream("application.properties")) {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception appropriately
            }

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Properties hibernateProperties = new Properties();
            hibernateProperties.setProperty("hibernate.connection.url", url);
            hibernateProperties.setProperty("hibernate.connection.username", username);
            hibernateProperties.setProperty("hibernate.connection.password", password);

            sessionFactory = new Configuration()
                    .addProperties(hibernateProperties)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace();
            // Handle the exception appropriately
        }
    }
}
