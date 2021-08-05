package com.fightbook.commonManager.Exception;

public class FlightBookingException extends Exception {
	String message =null;
	public FlightBookingException(String m) {
		super();
		this.message=m;
	}
	public String getMessage(){
		return this.message;
	}

}
