package com.example.test.controller;

import com.example.test.service.Service;

import java.util.List;
import java.util.Optional;

class DefaultController<T, I> implements Controller<T, I> {

    private final Service<T, I> service;

    DefaultController(Service<T, I> service) {
        this.service = service;
    }

    @Override
    public void findAllAndPrint() {
        List<T> entities = service.findAll();
        System.out.println("Founded entities:");
        for (T entity : entities) {
            System.out.println("\t" + entity);
        }
    }

    @Override
    public void findByIdAndPrint(I id) {
        Optional<T> optionalEntity = service.findById(id);

        optionalEntity.ifPresentOrElse(
                entity -> System.out.printf("Entity was found: %s%n", entity),
                () -> System.out.printf("No such entity: id = %s%n", id)
        );
    }

    @Override
    public void saveAndPrint(T entity) {
        T savedEntity = service.save(entity);
        System.out.printf("Entity was saved: %s%n", savedEntity);
    }

    @Override
    public void deleteAndPrint(I id) {
        if (service.delete(id)) {
            System.out.printf("Book was deleted: id = %s%n", id);
        } else {
            System.out.printf("Book cannot be deleted: id = %s%n", id);
        }
    }
}
