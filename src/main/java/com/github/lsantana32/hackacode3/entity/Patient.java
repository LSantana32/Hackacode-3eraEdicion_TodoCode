package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.model.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient extends Person {
    private boolean medicalInsurance;
    @OneToMany(mappedBy = "patient")
    private List<DoctorAppointment> doctorAppointment;

    public Patient(int id, String name, String surname, String dni, String birthday, String email, String phone, String address, boolean medicalInsurance, List<DoctorAppointment> doctorAppointment) {
        super(id, name, surname, dni, birthday, email, phone, address);
        this.medicalInsurance = medicalInsurance;
        this.doctorAppointment = (doctorAppointment==null)?new ArrayList<>():doctorAppointment;
    }

    public Patient() {}

    public void addDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.add(doctorAppointment);
    }

    public void removeDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.remove(doctorAppointment);
    }
}
