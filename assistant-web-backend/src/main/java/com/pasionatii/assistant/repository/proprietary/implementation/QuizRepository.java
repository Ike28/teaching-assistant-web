package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Quiz;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IQuizRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuizRepository implements IQuizRepository {

    private SessionFactory sessionFactory;

    public QuizRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Quiz> findQuizzesByCourse_Id(Long courseId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Quiz> query = session.createQuery("FROM Quiz WHERE course.id = :courseId", Quiz.class);
            query.setParameter("courseId", courseId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Quiz entity) {
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
            Quiz quiz = session.get(Quiz.class, id);
            if (quiz != null) {
                session.delete(quiz);
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
    public Quiz findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Quiz.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Quiz entity, Quiz newEntity) {
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
    public Iterable<Quiz> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Quiz", Quiz.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
