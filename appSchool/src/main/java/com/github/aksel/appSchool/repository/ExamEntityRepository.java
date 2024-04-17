package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamEntityRepository extends JpaRepository<ExamEntity, Long> {
}