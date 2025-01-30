package com.github.lsantana32.hackacode3.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
import java.util.Date;
@Data
@Entity
@Table(name = "doctor_appointments")
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "doctor_fk")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patient_fk")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "service_package_fk")
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


    public DoctorAppointment() {}


}