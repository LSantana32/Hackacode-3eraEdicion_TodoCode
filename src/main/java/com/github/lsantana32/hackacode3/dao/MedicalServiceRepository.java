package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.enums.TypeOfMedicalService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.github.lsantana32.hackacode3.entity.MedicalService;

@Repository
public interface MedicalServiceRepository extends CrudRepository<MedicalService, Long> {
    boolean existsByNameAndType(String name, TypeOfMedicalService type);
}
