package com.github.aksel.appSchool.exception.globalcontroller;

import com.github.aksel.appSchool.exception.exceptions.CarNotFoundException;
import com.github.aksel.appSchool.exception.exceptions.LessonNotFoundException;
import com.github.aksel.appSchool.exception.exceptions.StudentNotFoundException;
import com.github.aksel.appSchool.exception.exceptions.TrainerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TrainerNotFoundException.class)
    public ResponseEntity<String> handleTrainerNotFoundException(TrainerNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<String> handleLessonNotFoundException(LessonNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

}
