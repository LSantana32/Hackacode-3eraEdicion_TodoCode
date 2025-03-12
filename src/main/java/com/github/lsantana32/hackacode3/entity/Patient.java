package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.model.Person;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "patients")
@Data
public class Patient extends Person {
    private Boolean medicalInsurance;
    @OneToMany(mappedBy = "patient")
    private List<DoctorAppointment> doctorAppointment;

    public Patient(int id, String name, String surname, String dni, Date birthday, String email, String phone, String address, boolean medicalInsurance) {
        super(id, name, surname, dni, birthday, email, phone, address);
        this.medicalInsurance = medicalInsurance;
        this.doctorAppointment = new ArrayList<>();
    }

    public Patient() {}

    public void addDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.add(doctorAppointment);
    }

    public void removeDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.remove(doctorAppointment);
    }

}
