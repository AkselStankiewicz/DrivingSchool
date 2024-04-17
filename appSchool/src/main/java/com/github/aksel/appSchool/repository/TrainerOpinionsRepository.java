package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.TrainerOpinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerOpinionsRepository extends JpaRepository<TrainerOpinion, Long> {
}