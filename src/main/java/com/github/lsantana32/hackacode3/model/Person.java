package com.github.lsantana32.hackacode3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    private String address;

    public Person(int id, String name, String surname, String dni, Date birthday, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        if (dni.length() != 8) {throw new IllegalArgumentException("DNI must have 8 digits");}
        this.dni = dni;
        if (birthday.after(new Date())) {throw new IllegalArgumentException("Birthday must be before today");}
        this.birthday = birthday;
        this.email = email;
        if (phone.length() != 8) {throw new IllegalArgumentException("Phone must have 8 digits");}
        this.phone = phone;
        this.address = address;
    }

    public Person() {}


    public void setDni(String dni){
        if (dni.length() != 8) {throw new IllegalArgumentException("DNI must have 8 digits");}
        this.dni = dni;
    }
}
