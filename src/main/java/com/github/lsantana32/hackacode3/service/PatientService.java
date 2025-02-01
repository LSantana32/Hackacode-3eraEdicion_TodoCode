package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.dao.PatientRepository;
import com.github.lsantana32.hackacode3.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseServiceImpl<Patient> {
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        super(patientRepository);
    }
}
