package com.github.aksel.appSchool.repository;

import com.github.aksel.appSchool.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentEntityRepository extends JpaRepository<PaymentEntity, Long> {
}