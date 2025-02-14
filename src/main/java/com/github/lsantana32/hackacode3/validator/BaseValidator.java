package com.github.lsantana32.hackacode3.validator;

import com.github.lsantana32.hackacode3.dao.CustomRepository;
import jakarta.persistence.EntityExistsException;

public class BaseValidator {
    public static <T> void validateExistenceByDni(String dni, T entity, CustomRepository<T> repository) {
        if (repository.findByDni(dni) != null) {
            throw new EntityExistsException("%s with dni %s already exist".formatted(entity, dni));
        }
    }

    public static <T> void validateExistenceById(long id, CustomRepository<T> repository) {
        if (repository.findById(id).isEmpty()) {
            throw new EntityExistsException("Id %s not found".formatted(id));
        }
    }
}
