package com.github.lsantana32.hackacode3.validator;

import com.github.lsantana32.hackacode3.dao.CustomRepository;
import jakarta.persistence.EntityExistsException;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class Doc_PatientValidator {
    private static final Logger logger = Logger.getLogger(Doc_PatientValidator.class.getName());
    public static <T> void validateNotExistenceByDni(String dni, T entity, CustomRepository<T> repository) {
        if (repository.findByDni(dni) != null) {
            throw new EntityExistsException("%s with dni %s already exist".formatted(entity, dni));
        }
    }

    public static <T> void validateExistenceById(long id, CustomRepository<T> repository) {
        if (repository.findById(id).isEmpty()) {
            throw new EntityExistsException("Id %s not found".formatted(id));
        }
    }

    public static <T> void validateInformation(T entity) {
        Class<?> currentClass = entity.getClass();
        while (currentClass != null) {
            validateFields(entity, currentClass);
            currentClass = currentClass.getSuperclass();
        }
    }

    private static <T> void validateFields(T entity, Class<?> currentClass) {
        for (Field field : currentClass.getDeclaredFields()) {
            // Skip these fields
            if (IsOneOfTheseFields(field, "id", "doctorAppointment", "availability")) {
                continue;
            }
            field.setAccessible(true);
            validateField(entity, field);
        }
    }

    private static <T> void validateField(T entity, Field field) {
        try {
            Object value = field.get(entity);
            validateIfNull(field.getName(), value);
            validateIfEmpty(value.toString(), field.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void validateIfNull(String fieldName, Object value) {
        if (value == null) {
            throw new NullPointerException("Field %s is null".formatted(fieldName));
        }
    }

    private static void validateIfEmpty(String value, String fieldName) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Field %s is empty".formatted(fieldName));
        }
    }


    private static boolean IsOneOfTheseFields(Field field, String... fieldNames) {
        for (String fieldName : fieldNames) {
            if (field.getName().equals(fieldName)) {
                return true;
            }
        }
        return false;
    }
}
