package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.dao.DoctorRepository;
import com.github.lsantana32.hackacode3.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseServiceImpl<Doctor> {
    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        super(doctorRepository);
    }
}