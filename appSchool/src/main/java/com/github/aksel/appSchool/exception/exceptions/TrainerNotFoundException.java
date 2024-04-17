package com.github.aksel.appSchool.exception.exceptions;

public class TrainerNotFoundException extends RuntimeException {
    public TrainerNotFoundException() {
        super("Trainer not found!");
    }
}
