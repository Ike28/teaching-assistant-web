package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Question;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IQuestionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository implements IQuestionRepository {

    private SessionFactory sessionFactory;

    public QuestionRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Question> findQuestionsByQuiz_Id(Long quizId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Question> query = session.createQuery("FROM Question WHERE quiz.id = :quizId", Question.class);
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
    public void save(Question entity) {
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
            Question question = session.get(Question.class, id);
            if (question != null) {
                session.delete(question);
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
    public Question findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Question.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Question entity, Question newEntity) {
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
    public Iterable<Question> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Question", Question.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
