package com.github.lsantana32.hackacode3.entity;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
@Data
public class DoctorAppointment {
    private int id;
    private Date date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    private ServicePackage servicePackage;
    private double price;
    private boolean paid;

    public DoctorAppointment(int id, Date date, LocalTime time, Doctor doctor, Patient patient, ServicePackage servicePackage, boolean paid) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
        this.servicePackage = servicePackage;
        this.price = servicePackage.getPrice();
        this.paid = paid;
    }


}
