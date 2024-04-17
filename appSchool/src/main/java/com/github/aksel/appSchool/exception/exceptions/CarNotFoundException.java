package com.github.aksel.appSchool.exception.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Car not found!");
    }
}
