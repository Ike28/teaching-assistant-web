package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.GradeAssignment;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IGradeAssignmentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GradeAssignmentRepository implements IGradeAssignmentRepository {

    private SessionFactory sessionFactory;

    public GradeAssignmentRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<GradeAssignment> findGradeAssignmentsByAssignment_Id(Long assignmentId) {
        Session session = sessionFactory.openSession();
        try {
            Query<GradeAssignment> query = session.createQuery("FROM GradeAssignment WHERE assignment.id = :assignmentId", GradeAssignment.class);
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
    public void save(GradeAssignment entity) {
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
            GradeAssignment gradeAssignment = session.get(GradeAssignment.class, id);
            if (gradeAssignment != null) {
                session.delete(gradeAssignment);
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
    public GradeAssignment findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(GradeAssignment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(GradeAssignment entity, GradeAssignment newEntity) {
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
    public Iterable<GradeAssignment> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM GradeAssignment", GradeAssignment.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
