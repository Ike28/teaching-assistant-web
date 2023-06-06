package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Task;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.ITaskRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskRepository implements ITaskRepository {

    private SessionFactory sessionFactory;

    public TaskRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void save(Task entity) {
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
            Task task = session.get(Task.class, id);
            if (task != null) {
                session.delete(task);
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
    public Task findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Task.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Task entity, Task newEntity) {
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
    public Iterable<Task> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Task", Task.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Task> findTasksByAssignment_Id(Long assignmentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Task> query = session.createQuery("FROM Task WHERE assignment.id = :assignmentId", Task.class);
            query.setParameter("assignmentId", assignmentId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
