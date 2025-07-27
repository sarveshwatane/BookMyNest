package com.cdac.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookedRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(name = "check_IN")
	private LocalDate checkInDate;
	
	@Column(name = "check_Out")
	private LocalDate checkOutDate;
	
	@Column(name = "guest_FullName")
	private String guestFullName;
	
	@Column(name = "guest_Email")
	private String guestEmail;
	
	@Column(name = "adult")
	private int NumberofAdults;
	
	@Column(name = "Children")
	private int NumberofChildren;
	
	@Column(name = "total_guest")
	private int totalNumberofGuest;
	
	@Column(name = "confirmation_Code")
	private String bookingConfirmationCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "room_id")
	private Room room;
	
	
	
	
	
	public void calculateTotalNumberofGuest() {
		this.totalNumberofGuest = this.NumberofAdults + NumberofChildren;
	}

	public void setNumberofAdults(int numberofAdults) {
		NumberofAdults = numberofAdults;
		calculateTotalNumberofGuest();
	}

	public void setNumberofChildren(int numberofChildren) {
		NumberofChildren = numberofChildren;
		calculateTotalNumberofGuest();
	}


	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}
	
	

	
	
	
	
}
