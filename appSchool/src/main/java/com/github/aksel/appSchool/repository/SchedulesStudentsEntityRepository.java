package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.SchedulesStudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesStudentsEntityRepository extends JpaRepository<SchedulesStudentsEntity, Long> {
}