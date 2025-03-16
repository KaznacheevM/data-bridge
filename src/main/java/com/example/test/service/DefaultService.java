package com.example.test.service;

import com.example.test.repository.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

class DefaultService<T, I> implements Service<T, I> {

    private final Repository<T, I> repository;

    DefaultService(Repository<T, I> repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(I id) {
        T book = repository.findByID(id);
        return Optional.ofNullable(book);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(I id) {
        return repository.delete(id);
    }
}
