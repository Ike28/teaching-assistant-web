package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.Student;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class StudentRepository implements IStudentRepository {

    private SessionFactory sessionFactory;

    public StudentRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Student> findStudentsByAssignedClass_Id(Long classId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Student> query = session.createQuery("FROM Student WHERE assignedClass.id = :classId", Student.class);
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
    public Optional<Student> findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query<Student> query = session.createQuery("FROM Student WHERE email = :email AND password = :password", Student.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Student entity) {
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
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
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
    public Student findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Student entity, Student newEntity) {
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
    public Iterable<Student> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
