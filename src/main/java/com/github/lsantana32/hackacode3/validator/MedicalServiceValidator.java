package com.github.lsantana32.hackacode3.validator;

import com.github.lsantana32.hackacode3.dao.MedicalServiceRepository;
import com.github.lsantana32.hackacode3.entity.MedicalService;
import com.github.lsantana32.hackacode3.enums.TypeOfMedicalService;
import com.github.lsantana32.hackacode3.exception.EmptyFieldException;
import jakarta.persistence.EntityExistsException;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class MedicalServiceValidator {
    private static Logger logger = Logger.getLogger(MedicalServiceValidator.class.getName());

    public static void validateInformation(MedicalService medicalService) {
        validateFields(medicalService);
    }

    private static void validateFields(MedicalService medicalService) {
        for (Field field : medicalService.getClass().getDeclaredFields()){
            if (isOneOfTheseFields(field, "id", "servicePackage")){
                continue;
            }
            field.setAccessible(true);
            logger.info("Validating field %s".formatted(field.getName()));
            validateField(medicalService, field);
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

    private static void validateField(MedicalService medicalService, Field field) {
        try{
            Object value = field.get(medicalService);
            logger.info("Validating field %s with value %s".formatted(field.getName(), value));
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



    public static void validateNotExistenceByNameAndType(String name, TypeOfMedicalService type, MedicalServiceRepository repository) {
        if (repository.existsByNameAndType(name, type)){
            throw new EntityExistsException("Medical Service already exists");
        }
    }

    public static void validateExistenceById(long id, MedicalServiceRepository repository) {
        if (!repository.existsById(id)){
            throw new EntityExistsException("Medical Service does not exist");
        }
    }
}
