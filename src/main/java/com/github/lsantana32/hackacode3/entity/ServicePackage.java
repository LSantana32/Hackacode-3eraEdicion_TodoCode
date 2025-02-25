package com.github.lsantana32.hackacode3.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "service_packages")
public class ServicePackage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @OneToMany(mappedBy = "servicePackage")
    private List<MedicalService> services;
    private Double price;
    private Boolean medicalInsurancePatient;
    @OneToMany(mappedBy = "servicePackage")
    private List<DoctorAppointment> doctorAppointment;

    public ServicePackage(int id, List<MedicalService> services, boolean medicalInsurancePatient, List<DoctorAppointment> doctorAppointment) {
        this.id = id;
        this.services = services;
        this.medicalInsurancePatient = medicalInsurancePatient;
        this.price = services.stream().mapToDouble(MedicalService::getPrice).sum()*(0.85-0.20*(medicalInsurancePatient?1:0));
        this.doctorAppointment = (doctorAppointment==null)?new ArrayList<>():doctorAppointment;
    }

    public ServicePackage() {
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void addDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.add(doctorAppointment);
    }

    public void removeDoctorAppointment(DoctorAppointment doctorAppointment){
        this.doctorAppointment.remove(doctorAppointment);
    }
}
