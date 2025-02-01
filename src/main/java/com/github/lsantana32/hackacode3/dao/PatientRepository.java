package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByDni(String dni);
}
