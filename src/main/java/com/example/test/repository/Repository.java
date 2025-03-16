package com.example.test.repository;

import java.util.List;

public interface Repository<T, I> {

    List<T> findAll();

    T findByID(I id);

    T save(T entity);

    boolean delete(I id);

    static <T, I> Repository<T, I> forType(Class<T> entityType) {
        return new DefaultRepository<>(entityType);
    }
}
