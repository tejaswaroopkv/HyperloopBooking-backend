package com.fightbook.userManager.Exception;

public class UserBookingException extends Exception {
	String message =null;
	public UserBookingException(String m) {
		super();
		this.message=m;
	}
	public String getMessage(){
		return this.message;
	}

}
