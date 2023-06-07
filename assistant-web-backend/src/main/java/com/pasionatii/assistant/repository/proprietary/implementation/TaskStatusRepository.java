package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.repository.proprietary.ITaskStatusRepository;

import com.pasionatii.assistant.entity.TaskStatus;
import com.pasionatii.assistant.repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskStatusRepository implements ITaskStatusRepository {

    private SessionFactory sessionFactory;

    public TaskStatusRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void save(TaskStatus entity) {
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
            TaskStatus taskStatus = session.get(TaskStatus.class, id);
            if (taskStatus != null) {
                session.delete(taskStatus);
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
    public TaskStatus findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(TaskStatus.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(TaskStatus entity, TaskStatus newEntity) {
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
    public Iterable<TaskStatus> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM TaskStatus", TaskStatus.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<TaskStatus> findTaskStatusByTask_Id(Long taskId) {
        Session session = sessionFactory.openSession();
        try {
            Query<TaskStatus> query = session.createQuery("FROM TaskStatus WHERE task.id = :taskId", TaskStatus.class);
            query.setParameter("taskId", taskId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<TaskStatus> findTaskStatusByStudent_Id(Long studentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<TaskStatus> query = session.createQuery("FROM TaskStatus WHERE assignmentStatus.student.id = :studentId", TaskStatus.class);
            query.setParameter("studentId", studentId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
