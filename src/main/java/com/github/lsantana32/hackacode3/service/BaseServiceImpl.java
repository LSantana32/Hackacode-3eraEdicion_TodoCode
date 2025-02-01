package com.github.lsantana32.hackacode3.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected final CrudRepository<T, Long> repository;

    protected BaseServiceImpl(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public void register(T entity) {
        repository.save(entity);
    }

    @Override
    public Optional<T> getById(int id) {
        return repository.findById((long) id);
    }

    @Override
    public void delete(int id) {
        repository.deleteById((long) id);
    }

    @Override
    public void update(int id, T entity) {
        if (repository.existsById((long) id)) {
            repository.save(entity);
        } else {
            throw new IllegalArgumentException("Entity not found");
        }
    }
}