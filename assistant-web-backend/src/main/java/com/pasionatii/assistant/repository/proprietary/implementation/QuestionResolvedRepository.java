package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.QuestionResolved;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IQuestionResolvedRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionResolvedRepository implements IQuestionResolvedRepository {

    private SessionFactory sessionFactory;

    public QuestionResolvedRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<QuestionResolved> findQuestionResolvedByStudent_Id(Long studentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<QuestionResolved> query = session.createQuery("FROM QuestionResolved WHERE student.id = :studentId", QuestionResolved.class);
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
    public List<QuestionResolved> findQuestionResolvedByQuestion_Id(Long questionId) {
        Session session = sessionFactory.openSession();
        try {
            Query<QuestionResolved> query = session.createQuery("FROM QuestionResolved WHERE question.id = :questionId", QuestionResolved.class);
            query.setParameter("questionId", questionId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(QuestionResolved entity) {
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
            QuestionResolved questionResolved = session.get(QuestionResolved.class, id);
            if (questionResolved != null) {
                session.delete(questionResolved);
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
    public QuestionResolved findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(QuestionResolved.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(QuestionResolved entity, QuestionResolved newEntity) {
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
    public Iterable<QuestionResolved> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM QuestionResolved", QuestionResolved.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
