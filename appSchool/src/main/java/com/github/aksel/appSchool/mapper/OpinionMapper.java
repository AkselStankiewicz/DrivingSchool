package com.github.aksel.appSchool.mapper;

import com.github.aksel.appSchool.dto.opinion.TrainerOpinionDto;
import com.github.aksel.appSchool.entity.TrainerOpinion;
import org.springframework.stereotype.Component;

@Component
public class OpinionMapper {

    public TrainerOpinionDto toDto(TrainerOpinion entity) {
        TrainerOpinionDto dto = new TrainerOpinionDto();

        dto.setOpinion(entity.getOpinion());
        dto.setStudentName(entity.getStudent().getFirstName());
        dto.setStudentSurname(entity.getStudent().getLastName());

        return dto;
    }
}
