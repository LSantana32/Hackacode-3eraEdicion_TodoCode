package com.github.lsantana32.hackacode3.service;

import java.util.Optional;

public interface BaseService<T> {
    void register(T entity);
    Optional<T> getById(int id);
    void delete(int id);
    void update(int id, T entity);
}