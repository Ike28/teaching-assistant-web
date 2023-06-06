package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Admin;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IAdminRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class AdminRepository implements IAdminRepository {

    private SessionFactory sessionFactory;

    public AdminRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Optional<Admin> findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Admin> query = session.createQuery("FROM Admin WHERE email = :email AND password = :password", Admin.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            Optional<Admin> admin = query.uniqueResultOptional();
            transaction.commit();
            return admin;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Admin entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                session.delete(admin);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Admin findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Admin.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Admin entity, Admin newEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.evict(entity);
            session.update(newEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Iterable<Admin> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Admin", Admin.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}

