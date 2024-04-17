package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonEntityRepository extends JpaRepository<LessonEntity, Long> {

    List<LessonEntity> findAllByStudentId(Long id);
}