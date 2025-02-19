package com.github.lsantana32.hackacode3.exception;

public class MedicalServiceNotFoundException extends RuntimeException {
    public MedicalServiceNotFoundException(long id) {
        super("Medical service with id " + id + " not found");
    }
}
