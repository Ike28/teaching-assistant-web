package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.AssignmentStatus;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IAssignmentStatusRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AssignmentStatusRepository implements IAssignmentStatusRepository {

    private SessionFactory sessionFactory;

    public AssignmentStatusRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void save(AssignmentStatus entity) {
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
            AssignmentStatus assignmentStatus = session.get(AssignmentStatus.class, id);
            if (assignmentStatus != null) {
                session.delete(assignmentStatus);
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
    public AssignmentStatus findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(AssignmentStatus.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(AssignmentStatus entity, AssignmentStatus newEntity) {
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
    public Iterable<AssignmentStatus> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM AssignmentStatus", AssignmentStatus.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<AssignmentStatus> findAssignmentStatusByAssignment_Id(Long assignmentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<AssignmentStatus> query = session.createQuery("FROM AssignmentStatus WHERE assignment.id = :assignmentId", AssignmentStatus.class);
            query.setParameter("assignmentId", assignmentId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<AssignmentStatus> findAssignmentStatusByStudent_Id(Long studentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<AssignmentStatus> query = session.createQuery("FROM AssignmentStatus WHERE student.id = :studentId", AssignmentStatus.class);
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
