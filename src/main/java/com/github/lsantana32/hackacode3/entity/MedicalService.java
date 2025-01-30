package com.github.lsantana32.hackacode3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_services")
public class MedicalService {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "service_package_fk")
    private ServicePackage servicePackage;

    public MedicalService(int id, String name, String description, double price, ServicePackage servicePackage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.servicePackage = servicePackage;
    }

    public MedicalService() {
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
