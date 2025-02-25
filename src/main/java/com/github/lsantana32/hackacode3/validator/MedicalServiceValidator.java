package com.github.lsantana32.hackacode3.validator;

import com.github.lsantana32.hackacode3.dao.MedicalServiceRepository;
import com.github.lsantana32.hackacode3.entity.MedicalService;
import com.github.lsantana32.hackacode3.enums.TypeOfMedicalService;
import jakarta.persistence.EntityExistsException;

public class MedicalServiceValidator extends BaseValidator{

    public static void validateNotExistenceByNameAndType(String name, TypeOfMedicalService type, MedicalServiceRepository repository) {
        if (repository.existsByNameAndType(name, type)){
            throw new EntityExistsException("Medical Service already exists");
        }
    }

}
