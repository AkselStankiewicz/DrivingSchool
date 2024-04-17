package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllByEmail(String email);
}