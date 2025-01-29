package com.github.lsantana32.hackacode3.entity;

import lombok.Data;

import java.util.List;

@Data
public class ServicePackage {
    private int id;
    private List<MedicalService> services;
    private double price;
    private boolean medicalInsurancePatient;

    public ServicePackage(int id, List<MedicalService> services, boolean medicalInsurancePatient) {
        this.id = id;
        this.services = services;
        this.price = services.stream().mapToDouble(MedicalService::getPrice).sum()*(0.85-0.20*(medicalInsurancePatient?1:0));
    }
}
