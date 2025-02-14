package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CustomRepository<Patient> {
}
