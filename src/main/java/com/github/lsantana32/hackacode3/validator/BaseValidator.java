package com.github.lsantana32.hackacode3.validator;

import com.github.lsantana32.hackacode3.exception.EmptyFieldException;
import jakarta.persistence.EntityExistsException;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Field;

public abstract class BaseValidator {


    public static <T> void validateFields(T entity, String ...fieldsToIgnore) {
        for (Field field : entity.getClass().getDeclaredFields()){
            System.out.println("Validating field: " + field.getName());
            if (isOneOfTheseFields(field, fieldsToIgnore)){
                continue;
            }
            field.setAccessible(true);
            validateField(entity, field);
        }
    }

    private static boolean isOneOfTheseFields(Field field, String... fieldNames) {
        for (String fieldName : fieldNames){
            if (field.getName().equals(fieldName)){
                return true;
            }
        }
        return false;
    }

    private static <T> void validateField( T entity, Field field) {
        try{
            Object value = field.get(entity);
            validateIfNull(field.getName(), value);
            validateIfEmpty(value.toString(), field.getName());
            validatePrice(field.getName(), value);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    private static void validatePrice(String fieldName, Object value) {
        if (fieldName.equals("price")){
            validateIfISNegative(value);
        }
    }

    private static void validateIfISNegative(Object value) {
        if (value instanceof Double && (Double) value < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    private static void validateIfNull(String fieldName, Object value) {
        if (value == null){
            throw new NullPointerException("Field %S is null".formatted(fieldName));
        }
    }

    private static void validateIfEmpty(String value, String fieldName) {
        if (value.isEmpty()){
            throw new EmptyFieldException("Field %S is empty".formatted(fieldName));
        }
    }

    public static <T,ID>void validateExistenceById(ID id, CrudRepository<T,ID> repository, Class<T> entityClass) {
            if (!repository.existsById(id)) {
                throw new EntityExistsException(entityClass.getSimpleName() + "with ID " + id + " does not exist");
            }
        }
}

