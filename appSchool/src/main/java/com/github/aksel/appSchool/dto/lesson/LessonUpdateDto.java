package com.github.aksel.appSchool.dto.lesson;

import com.github.aksel.appSchool.entity.enums.LessonStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonUpdateDto {
    private Long id;
    private Long trainerId;
    private Long studentId;
    private String date;
    private String startingHour;
    private String endingHour;
    private LessonStatus status;
}
