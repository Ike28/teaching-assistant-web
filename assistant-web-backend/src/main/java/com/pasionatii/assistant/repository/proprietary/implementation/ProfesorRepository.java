package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Profesor;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IProfesorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ProfesorRepository implements IProfesorRepository {

    private SessionFactory sessionFactory;

    public ProfesorRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Optional<Profesor> findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query<Profesor> query = session.createQuery("FROM Profesor WHERE email = :email AND password = :password", Profesor.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            Profesor profesor = query.uniqueResult();
            return Optional.ofNullable(profesor);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Profesor entity) {
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
            Profesor profesor = session.get(Profesor.class, id);
            if (profesor != null) {
                session.delete(profesor);
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
    public Profesor findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Profesor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Profesor entity, Profesor newEntity) {
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
    public Iterable<Profesor> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Profesor", Profesor.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
