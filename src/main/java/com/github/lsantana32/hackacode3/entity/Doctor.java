package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.model.Person;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor extends Person {
    private String speciality;
    @ElementCollection
    private List<Date> availability;
    private Double salary;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<DoctorAppointment> doctorAppointment;

    public Doctor(int id, String name, String surname, String dni, Date birthday, String email, String phone, String address, String speciality, List<Date> availability, Double salary, List<DoctorAppointment> doctorAppointment) {
        super(id, name, surname, dni, birthday, email, phone, address);
        this.speciality = speciality;
        this.availability = (availability==null)?new ArrayList<>():availability;
        this.salary = salary;
        this.doctorAppointment = (doctorAppointment==null)?new ArrayList<>():doctorAppointment;
    }

    public Doctor() {}

    public void addDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.add(doctorAppointment);
    }

    public void removeDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.remove(doctorAppointment);
    }

    public void addAvailability(Date date){
        this.availability.add(date);
    }

    public void removeAvailability(Date date){
        this.availability.remove(date);
    }
}
