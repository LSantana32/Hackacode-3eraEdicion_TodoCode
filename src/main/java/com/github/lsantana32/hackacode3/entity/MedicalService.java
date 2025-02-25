package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.enums.TypeOfMedicalService;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_services")
public class MedicalService {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private TypeOfMedicalService type;
    private String name;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "servicePakageID")
    private ServicePackage servicePackage;

    public MedicalService(int id, TypeOfMedicalService type, String name, String description, double price, ServicePackage servicePackage) {
        this.id = id;
        this.type = type;
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
