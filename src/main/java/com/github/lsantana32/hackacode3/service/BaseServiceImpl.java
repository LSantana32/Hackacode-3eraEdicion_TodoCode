package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.dao.CustomRepository;
import com.github.lsantana32.hackacode3.parse.IterableToList;
import com.github.lsantana32.hackacode3.validator.BaseValidator;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected final CustomRepository<T> repository;

    protected BaseServiceImpl(CustomRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void register(String dni, T entity) {
        BaseValidator.validateInformation(entity);
        BaseValidator.validateExistenceByDni(dni, entity, repository);
        repository.save(entity);
    }

    @Override
    public Optional<T> getById(long id) {
        BaseValidator.validateExistenceById(id, repository);
        return repository.findById(id);
    }

    @Override
    public void delete(long id) {
        BaseValidator.validateExistenceById(id, repository);
        repository.deleteById((long) id);
    }

    @Override
    public void update(long id, T entity) {
        BaseValidator.validateExistenceById(id, repository);
        repository.save(entity);
    }

    @Override
    public List<T> getAll() {
        return IterableToList.convert(repository.findAll());
    }
}