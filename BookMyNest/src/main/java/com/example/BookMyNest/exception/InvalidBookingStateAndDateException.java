package com.example.BookMyNest.exception;

public class InvalidBookingStateAndDateException extends RuntimeException{
	public InvalidBookingStateAndDateException(String message) {
		super(message);
	}

}
