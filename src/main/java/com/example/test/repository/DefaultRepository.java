package com.example.test.repository;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

import static com.example.test.util.HibernateUtil.openSession;

class DefaultRepository<T, I> implements Repository<T, I> {

    private final Class<T> entityType;

    DefaultRepository(Class<T> entityType) {
        this.entityType = Objects.requireNonNull(entityType);
    }

    @Override
    public List<T> findAll() {
        String queryStr = String.format("FROM %s", entityType.getSimpleName());
        try (Session session = openSession()) {
            Query<T> query = session.createQuery(queryStr, entityType);
            return query.list();
        }
    }

    @Override
    public T findByID(I id) {
        try (Session session = openSession()) {
            return session.find(entityType, id);
        }
    }

    @Override
    public T save(T entity) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(entity);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }

        return entity;
    }

    @Override
    public boolean delete(I id) {
        T entity = findByID(id);
        if (entity == null) {
            return false;
        }

        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.remove(entity);
                transaction.commit();
                return true;
            } catch (Exception e) {
                transaction.rollback();
                return false;
            }
        }
    }
}
