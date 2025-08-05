package com.example.BookMyNest.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.BookMyNest.enums.NotificationType;
import com.example.BookMyNest.enums.PaymentGateWay;
import com.example.BookMyNest.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "notification")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subject;
	
	@NotBlank(message = "recipient is required")
	private String recipient;
	
	private String body;
	
	private String bookingReference;
	
	@Enumerated(EnumType.STRING)
	private NotificationType type;
	
	private final LocalDateTime createdAt = LocalDateTime.now();
}
