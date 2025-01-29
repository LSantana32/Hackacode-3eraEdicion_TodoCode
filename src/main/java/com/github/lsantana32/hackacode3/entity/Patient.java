package com.github.lsantana32.hackacode3.entity;

import com.github.lsantana32.hackacode3.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient extends Person {
    private boolean medicalInsurance;

    public Patient(int id, String name, String surname, String dni, String birthday, String email, String phone, String address, boolean medicalInsurance) {
        super(id, name, surname, dni, birthday, email, phone, address);
        this.medicalInsurance = medicalInsurance;
    }

}
