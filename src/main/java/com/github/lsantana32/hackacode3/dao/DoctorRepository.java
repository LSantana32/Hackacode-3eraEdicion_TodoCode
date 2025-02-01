package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Doctor findByDni(String dni);
}
