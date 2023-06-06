package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Assignment;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IAssignmentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AssignmentRepository implements IAssignmentRepository {

    private SessionFactory sessionFactory;

    public AssignmentRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

//    @Override
//    public List<Assignment> findAssignmentsByAssignedClass_Id(Long classId) {
//        Session session = sessionFactory.openSession();
//        try {
//            Query<Assignment> query = session.createQuery("FROM Assignment WHERE assignedClass.id = :classId", Assignment.class);
//            query.setParameter("classId", classId);
//            return query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            session.close();
//        }
//    }

    @Override
    public List<Assignment> findAssignmentsByCourse_Id(Long courseId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Assignment> query = session.createQuery("FROM Assignment WHERE course.id = :courseId", Assignment.class);
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
    public void save(Assignment entity) {
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
            Assignment assignment = session.get(Assignment.class, id);
            if (assignment != null) {
                session.delete(assignment);
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
    public Assignment findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Assignment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Assignment entity, Assignment newEntity) {
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
    public Iterable<Assignment> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Assignment", Assignment.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
