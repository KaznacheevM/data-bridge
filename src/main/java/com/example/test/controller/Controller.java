package com.example.test.controller;

import com.example.test.service.Service;

public interface Controller<T, I> {

    void findAllAndPrint();

    void findByIdAndPrint(I id);

    void saveAndPrint(T entity);

    void deleteAndPrint(I id);

    static <T, I> Controller<T, I> forType(Class<T> entityType) {
        Service<T, I> service = Service.forType(entityType);
        return new DefaultController<>(service);
    }
}
