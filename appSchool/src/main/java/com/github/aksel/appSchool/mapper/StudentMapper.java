package com.github.aksel.appSchool.mapper;

import com.github.aksel.appSchool.dto.student.StudentEntityDto;
import com.github.aksel.appSchool.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentEntityDto toDto(StudentEntity student) {
        return new StudentEntityDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getHoursLeft(),
                student.getHoursDriven()
        );
    }
}
