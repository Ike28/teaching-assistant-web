package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.GradeQuiz;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IGradeQuizRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GradeQuizRepository implements IGradeQuizRepository {

    private SessionFactory sessionFactory;

    public GradeQuizRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<GradeQuiz> findGradeQuizsByQuiz_Id(Long quizId) {
        Session session = sessionFactory.openSession();
        try {
            Query<GradeQuiz> query = session.createQuery("FROM GradeQuiz WHERE quiz.id = :quizId", GradeQuiz.class);
            query.setParameter("quizId", quizId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(GradeQuiz entity) {
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
            GradeQuiz gradeQuiz = session.get(GradeQuiz.class, id);
            if (gradeQuiz != null) {
                session.delete(gradeQuiz);
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
    public GradeQuiz findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(GradeQuiz.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(GradeQuiz entity, GradeQuiz newEntity) {
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
    public Iterable<GradeQuiz> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM GradeQuiz", GradeQuiz.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
