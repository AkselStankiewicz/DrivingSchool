package com.github.aksel.appSchool.dto.lesson;

import com.github.aksel.appSchool.dto.trainer.TrainerEntityDto;
import com.github.aksel.appSchool.dto.student.StudentEntityDto;
import com.github.aksel.appSchool.entity.enums.LessonStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LessonEntityDto {
    private Long id;
    private TrainerEntityDto trainer;
    private StudentEntityDto student;
    private Date date;
    private String startingHour;
    private String endingHour;
    private LessonStatus status;

}
