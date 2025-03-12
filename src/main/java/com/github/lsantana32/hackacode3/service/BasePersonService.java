package com.github.lsantana32.hackacode3.service;

import java.util.List;
import java.util.Optional;

public interface BasePersonService<T> {
    void register(String dni, T entity);
    Optional<T> getById(long id);
    void delete(long id);
    void update(long id, T entity);
    List<T> getAll();
}