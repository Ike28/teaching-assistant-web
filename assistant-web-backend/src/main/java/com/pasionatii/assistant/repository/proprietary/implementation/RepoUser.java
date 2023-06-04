package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.User;
import com.pasionatii.assistant.repository.proprietary.Repository;
import com.pasionatii.assistant.repository.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RepoUser implements Repository<User> {

    private final SessionFactory sessionFactory;

    public RepoUser(SessionFactory sessionFactory) {
        SessionFactoryProvider sessionFactoryProvider=new SessionFactoryProvider();
         this.sessionFactory=sessionFactoryProvider.getSessionFactory();
    }

    @Override
    public void save(User entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findOneById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User entity, User newEntity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.evict(entity);
            session.update(newEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM  User", com.pasionatii.assistant.entity.User.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}