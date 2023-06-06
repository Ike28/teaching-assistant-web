package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Course;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.ICourseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseRepository implements ICourseRepository {

    private SessionFactory sessionFactory;

    public CourseRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Course> findByCourseClassId(Long classId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Course> query = session.createQuery("FROM Course WHERE assignedClass.id = :classId", Course.class);
            query.setParameter("classId", classId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Course> findByProfessorId(Long profesorId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Course> query = session.createQuery("FROM Course WHERE professor.id = :profesorId", Course.class);
            query.setParameter("profesorId", profesorId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Course entity) {
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
            Course course = session.get(Course.class, id);
            if (course != null) {
                session.delete(course);
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
    public Course findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Course.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Course entity, Course newEntity) {
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
    public Iterable<Course> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Course", Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
