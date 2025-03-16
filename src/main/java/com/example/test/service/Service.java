package com.example.test.service;

import com.example.test.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface Service<T, I> {

    List<T> findAll();

    Optional<T> findById(I id);

    T save(T entity);

    boolean delete(I id);

    static <T, I> Service<T, I> forType(Class<T> entityType) {
        Repository<T, I> repository = Repository.forType(entityType);
        return new DefaultService<>(repository);
    }
}
