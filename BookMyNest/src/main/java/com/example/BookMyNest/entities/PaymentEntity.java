package com.example.BookMyNest.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.BookMyNest.enums.PaymentGateWay;
import com.example.BookMyNest.enums.PaymentStatus;
import com.example.BookMyNest.enums.RoomType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "payments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String transcationId;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentGateWay paymentGateway;
	
	private LocalDateTime paymentDate;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private String bookingReference;
	private String failureReason;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

}
