package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Grade;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IGradeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GradeRepository implements IGradeRepository {

    private SessionFactory sessionFactory;

    public GradeRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Grade> findGradesByStudent_Id(Long studentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Grade> query = session.createQuery("FROM Grade WHERE student.id = :studentId", Grade.class);
            query.setParameter("studentId", studentId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Grade entity) {
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
            Grade grade = session.get(Grade.class, id);
            if (grade != null) {
                session.delete(grade);
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
    public Grade findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Grade.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Grade entity, Grade newEntity) {
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
    public Iterable<Grade> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Grade", Grade.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
