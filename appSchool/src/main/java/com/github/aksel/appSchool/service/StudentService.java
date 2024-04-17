package com.github.aksel.appSchool.service;

import com.github.aksel.appSchool.dto.lesson.LessonEntityDto;
import com.github.aksel.appSchool.dto.lesson.LessonRequestDto;
import com.github.aksel.appSchool.dto.lesson.LessonUpdateDto;
import com.github.aksel.appSchool.dto.student.StudentEntityDto;
import com.github.aksel.appSchool.dto.student.StudentRegisterDto;
import com.github.aksel.appSchool.entity.LessonEntity;
import com.github.aksel.appSchool.entity.StudentEntity;
import com.github.aksel.appSchool.entity.enums.LessonStatus;
import com.github.aksel.appSchool.exception.exceptions.LessonNotFoundException;
import com.github.aksel.appSchool.exception.exceptions.StudentNotFoundException;
import com.github.aksel.appSchool.exception.exceptions.TrainerNotFoundException;
import com.github.aksel.appSchool.mapper.LessonMapper;
import com.github.aksel.appSchool.mapper.StudentMapper;
import com.github.aksel.appSchool.repository.LessonEntityRepository;
import com.github.aksel.appSchool.repository.StudentEntityRepository;
import com.github.aksel.appSchool.repository.TrainerEntityRepository;
import com.github.aksel.appSchool.utils.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentEntityRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PasswordHasher passwordHasher;
    private final LessonEntityRepository lessonRepository;
    private final TrainerEntityRepository trainerEntityRepository;
    private final LessonMapper lessonMapper;

    public StudentEntityDto findStudentById(Long id) {
        StudentEntity entity = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        StudentEntityDto dto = studentMapper.toDto(entity);

        return dto;
    }

    public List<StudentEntityDto> findStudentByEmail(String email) {
        List<StudentEntity> entities = studentRepository.findAllByEmail(email);
        return entities.stream()
                .map(studentMapper::toDto)
                .toList();
    }

    public StudentEntity registerStudent(StudentRegisterDto dto) {
        StudentEntity entity = new StudentEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(passwordHasher.hashPassword(dto.getPassword()));
        entity.setPhoneNumber(dto.getPhoneNumber());

        return studentRepository.save(entity);
    }

    public LessonEntity findLessonById(Long id) {
        LessonEntity entity = lessonRepository.findById(id).orElseThrow(LessonNotFoundException::new);

        return entity;
    }

    public LessonEntityDto requestLesson(LessonRequestDto lessonDto) {
        LessonEntity lesson = new LessonEntity();
        lesson.setDate(Date.valueOf(lessonDto.getDate()));
        lesson.setStatus(LessonStatus.PENDING);
        lesson.setStartingHour(lessonDto.getStartingHour());
        lesson.setEndingHour(lessonDto.getEndingHour());
        lesson.setStudent(studentRepository.findById(lessonDto.getStudentId()).orElseThrow(StudentNotFoundException::new));
        lesson.setTrainer(trainerEntityRepository.findById(lessonDto.getTrainerId()).orElseThrow(TrainerNotFoundException::new));

        return lessonMapper.toDto(lessonRepository.save(lesson));
    }

    public LessonEntityDto updateLesson(LessonUpdateDto lessonUpdated) {
        LessonEntity lessonToUpdate = lessonRepository.findById(lessonUpdated.getId()).orElseThrow(LessonNotFoundException::new);
        lessonToUpdate.setDate(Date.valueOf(lessonUpdated.getDate()));
        lessonToUpdate.setStatus(lessonUpdated.getStatus());
        lessonToUpdate.setStartingHour(lessonUpdated.getStartingHour());
        lessonToUpdate.setEndingHour(lessonUpdated.getEndingHour());
        lessonToUpdate.setTrainer(trainerEntityRepository.findById(lessonUpdated.getTrainerId()).orElseThrow(TrainerNotFoundException::new));
        lessonToUpdate.setStudent(studentRepository.findById(lessonUpdated.getStudentId()).orElseThrow(StudentNotFoundException::new));

        System.out.println(lessonToUpdate.getStatus());

        lessonRepository.save(lessonToUpdate);

        return lessonMapper.toDto(lessonToUpdate);
    }

    public List<LessonEntity> getLessonsByStudentId(Long id) {
        return lessonRepository.findAllByStudentId(id);
    }
}
