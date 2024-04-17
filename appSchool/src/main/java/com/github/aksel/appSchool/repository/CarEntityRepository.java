package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Long> {
    Optional<CarEntity> findCarEntityById(Long id);
}