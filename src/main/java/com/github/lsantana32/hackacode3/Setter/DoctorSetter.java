package com.github.lsantana32.hackacode3.Setter;

import com.github.lsantana32.hackacode3.entity.Doctor;

public interface DoctorSetter {
    static void setDoctor(Doctor doctor, Doctor NewDoctor){
        doctor.setName(NewDoctor.getName());
        doctor.setSurname(NewDoctor.getSurname());
        doctor.setSpeciality(NewDoctor.getSpeciality());
        doctor.setPhone(NewDoctor.getPhone());
        doctor.setAddress(NewDoctor.getAddress());
        doctor.setEmail(NewDoctor.getEmail());
        doctor.setSalary(NewDoctor.getSalary());
    };
}
