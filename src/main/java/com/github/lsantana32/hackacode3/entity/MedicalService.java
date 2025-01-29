package com.github.lsantana32.hackacode3.entity;

import lombok.Data;

@Data
public class MedicalService {
    private int id;
    private String name;
    private String description;
    private double price;

    public MedicalService(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
