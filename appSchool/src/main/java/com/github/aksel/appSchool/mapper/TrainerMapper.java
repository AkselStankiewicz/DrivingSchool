package com.github.aksel.appSchool.mapper;

import com.github.aksel.appSchool.dto.trainer.TrainerEntityDto;
import com.github.aksel.appSchool.entity.TrainerEntity;
import com.github.aksel.appSchool.repository.TrainerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrainerMapper {

    private final OpinionMapper opinionMapper;
    private final TrainerEntityRepository trainerRepository;

    public TrainerEntityDto toDto(TrainerEntity entity) {

        Integer iPassRate = entity.getStudentsPassRate();
        Float fPassRate = Float.parseFloat(String.valueOf((iPassRate/10.0)));

        return new TrainerEntityDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getIdentifier(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                fPassRate,
                entity.getTrainerOpinions().stream().map(opinionMapper::toDto).toList());
    }

    public TrainerEntity toEntity(TrainerEntityDto dto) {

        float fPassRate = dto.getStudentsPassRate()*10;
        Integer iPassRate = Integer.parseInt(Float.toString(fPassRate));

        TrainerEntity entity = new TrainerEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setIdentifier(dto.getIdentifier());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setStudentsPassRate(iPassRate);
        entity.setTrainerOpinions(trainerRepository.findTrainerEntityByIdentifier(dto.getIdentifier()).orElse(new TrainerEntity()).getTrainerOpinions());
        return entity;
    }
}
