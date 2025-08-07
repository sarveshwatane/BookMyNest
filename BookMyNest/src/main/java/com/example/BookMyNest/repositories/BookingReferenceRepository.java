package com.example.BookMyNest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookMyNest.entities.BookingReference;

public interface BookingReferenceRepository extends JpaRepository<BookingReference, Long>{
	Optional<BookingReference> findByReferenceNo(String referenceNo);

}
