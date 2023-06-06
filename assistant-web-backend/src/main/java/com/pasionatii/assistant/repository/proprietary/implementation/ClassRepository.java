package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IClassRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.pasionatii.assistant.entity.Class;

public class ClassRepository implements IClassRepository {

    private SessionFactory sessionFactory;

    public ClassRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void save(Class entity) {
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
            Class classEntity = session.get(Class.class, id);
            if (classEntity != null) {
                session.delete(classEntity);
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
    public Class findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Class.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Class entity, Class newEntity) {
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
    public Iterable<Class> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Class", Class.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
