package com.pasionatii.assistant;

import com.pasionatii.assistant.repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {

            SessionFactory sessionFactory = null;
            Session session = null;
            Transaction transaction = null;

            try {
                // Obtain the session factory
                sessionFactory = HibernateUtil.getSessionFactory();

                // Open a new session
                session = sessionFactory.openSession();

                // Begin a transaction
                transaction = session.beginTransaction();

                // Perform a database operation (e.g., execute a query)
                // Here, we simply print the number of records in the "User" table
                Long count = (Long) session.createQuery("SELECT COUNT(*) FROM Class ").uniqueResult();
                System.out.println("Number of records in User table: " + count);

                // Commit the transaction
                transaction.commit();

                System.out.println("Connection to the database successful.");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                System.err.println("Error connecting to the database: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // Close the session
                if (session != null) {
                    session.close();
                }
                // Close the session factory
                if (sessionFactory != null) {
                    sessionFactory.close();
                }
            }
    }

}
