package com.github.aksel.appSchool.exception.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found!");
    }
}
