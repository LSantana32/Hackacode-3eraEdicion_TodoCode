package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.model.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Doctor extends Person {
    private String speciality;
    private String availability;
    private double salary;

    public Doctor(int id, String name, String surname, String dni, String birthday, String email, String phone, String address, String speciality, String availability, double salary) {
        super(id, name, surname, dni, birthday, email, phone, address);
        this.speciality = speciality;
        this.availability = availability;
        this.salary = salary;
    }

}
