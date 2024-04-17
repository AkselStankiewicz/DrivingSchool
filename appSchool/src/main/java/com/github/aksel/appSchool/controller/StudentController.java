package com.github.aksel.appSchool.controller;

import com.github.aksel.appSchool.dto.lesson.LessonEntityDto;
import com.github.aksel.appSchool.dto.lesson.LessonRequestDto;
import com.github.aksel.appSchool.dto.lesson.LessonUpdateDto;
import com.github.aksel.appSchool.dto.student.StudentEntityDto;
import com.github.aksel.appSchool.dto.student.StudentRegisterDto;
import com.github.aksel.appSchool.dto.trainer.TrainerEntityDto;
import com.github.aksel.appSchool.entity.LessonEntity;
import com.github.aksel.appSchool.entity.StudentEntity;
import com.github.aksel.appSchool.service.StudentService;
import com.github.aksel.appSchool.service.TrainerService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final TrainerService trainerService;
    private final StudentService studentService;

    @GetMapping("/trainers")
    public ResponseEntity<List<TrainerEntityDto>> getTrainers() {
        return ResponseEntity.ok(trainerService.getTrainers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentEntityDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/email/")
    public ResponseEntity<List<StudentEntityDto>> getStudentByEmail(@PathParam("email") String email) {
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> registerStudent(@RequestBody StudentRegisterDto dto) {
        return ResponseEntity.ok(studentService.registerStudent(dto));
    }

    @GetMapping("/lessons/{id}")
    public ResponseEntity<LessonEntity> getLessonById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findLessonById(id));
    }

    @GetMapping("/lessons/byStudent/{id}")
    public ResponseEntity<List<LessonEntity>> getLessonsByStudentId(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getLessonsByStudentId(id));
    }

    @PostMapping("/lessons/request")
    public ResponseEntity<LessonEntityDto> requestLesson(@RequestBody LessonRequestDto lesson) {
        LessonEntityDto entity = studentService.requestLesson(lesson);
        return ResponseEntity.ok(entity);
    }


    @PatchMapping("/lessons/update")
    public ResponseEntity<LessonEntityDto> updateLesson(@RequestBody LessonUpdateDto lesson) {
        return ResponseEntity.ok(studentService.updateLesson(lesson));
    }
}
