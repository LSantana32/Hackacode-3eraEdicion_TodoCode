package com.github.lsantana32.hackacode3.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String dni;
    private String birthday;
    private String email;
    private String phone;
    private String address;

    public Person(int id, String name, String surname, String dni, String birthday, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Person() {}
}
