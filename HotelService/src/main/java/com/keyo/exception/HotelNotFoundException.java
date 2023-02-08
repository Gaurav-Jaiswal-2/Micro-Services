package com.keyo.exception;

public class HotelNotFoundException  extends RuntimeException{

	public HotelNotFoundException() {}
	public HotelNotFoundException(String message) {
		super(message);
	}
}
