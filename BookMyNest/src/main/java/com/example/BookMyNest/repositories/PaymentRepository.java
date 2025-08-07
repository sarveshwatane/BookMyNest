package com.example.BookMyNest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyNest.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{

}
