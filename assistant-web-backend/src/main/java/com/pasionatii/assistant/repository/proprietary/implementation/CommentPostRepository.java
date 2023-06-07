package com.pasionatii.assistant.repository.proprietary.implementation;

import com.pasionatii.assistant.entity.CommentPost;
import com.pasionatii.assistant.repository.HibernateUtil;
import com.pasionatii.assistant.repository.proprietary.ICommentPostRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CommentPostRepository implements ICommentPostRepository {

    private SessionFactory sessionFactory;

    public CommentPostRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<CommentPost> findCommentPostsByPost_Id(Long postId) {
        Session session = sessionFactory.openSession();
        try {
            Query<CommentPost> query = session.createQuery("FROM CommentPost WHERE post.id = :postId", CommentPost.class);
            query.setParameter("postId", postId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(CommentPost entity) {
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
            CommentPost commentPost = session.get(CommentPost.class, id);
            if (commentPost != null) {
                session.delete(commentPost);
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
    public CommentPost findOneById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(CommentPost.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(CommentPost entity, CommentPost newEntity) {
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
    public Iterable<CommentPost> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM CommentPost", CommentPost.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
