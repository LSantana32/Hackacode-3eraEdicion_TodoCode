package com.github.lsantana32.hackacode3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
@Data
@Entity
@Table(name = "doctor_appointments")
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "doctor_fk")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patient_fk")
    private Patient patient;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private ServicePackage servicePackage;
    private Double price;
    private Boolean paid;

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