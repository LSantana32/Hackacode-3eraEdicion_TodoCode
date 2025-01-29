package com.github.lsantana32.hackacode3.model;

import lombok.Data;

@Data
public abstract class Person {
    private final int id;
    private final String name;
    private final String surname;
    private final String dni;
    private final String birthday;
    private final String email;
    private final String phone;
    private final String address;

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
}
