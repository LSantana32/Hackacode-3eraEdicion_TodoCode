package com.github.lsantana32.hackacode3.Setter;

import com.github.lsantana32.hackacode3.entity.Patient;

public interface PatientSetter {
    static void setPatient(Patient patient, Patient newPatient) {
        patient.setName(newPatient.getName());
        patient.setSurname(newPatient.getSurname());
        patient.setAddress(newPatient.getAddress());
        patient.setPhone(newPatient.getPhone());
        patient.setEmail(newPatient.getEmail());
        patient.setMedicalInsurance(newPatient.getMedicalInsurance());
    }
}
