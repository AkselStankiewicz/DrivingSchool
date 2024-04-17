package com.github.aksel.appSchool.exception.exceptions;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException() {
        super("Lesson not found!");
    }
}
