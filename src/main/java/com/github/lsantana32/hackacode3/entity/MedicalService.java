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

    public MedicalService(int id, TypeOfMedicalService type, String name, String description, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.price = price;
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
