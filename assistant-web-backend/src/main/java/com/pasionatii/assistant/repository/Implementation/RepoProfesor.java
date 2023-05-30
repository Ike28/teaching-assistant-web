package com.pasionatii.assistant.repository.Implementation;

import com.pasionatii.assistant.entity.Profesor;
import com.pasionatii.assistant.repository.Interface.IProfesorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class RepoProfesor implements IProfesorRepository {

    private SessionFactory sessionFactory;

    public RepoProfesor(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Profesor entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Profesor profesor = findOneById(id);
            if (profesor != null) {
                session.delete(profesor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Profesor findOneById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Profesor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Profesor entity, Profesor newEntity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            entity.setUsername(newEntity.getUsername());
            entity.setPassword(newEntity.getPassword());
            entity.setFirstname(newEntity.getFirstname());
            entity.setLastname(newEntity.getLastname());
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Profesor> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Profesor> query = session.createQuery("FROM profesor", Profesor.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Iterable<Profesor> findOneByUsernameAndPassword(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Profesor p WHERE p.username = :username AND p.password = :password";
            Query<Profesor> query = session.createQuery(hql, Profesor.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
