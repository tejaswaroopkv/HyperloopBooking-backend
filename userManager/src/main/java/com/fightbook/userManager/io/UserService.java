package com.fightbook.userManager.io;

import java.util.List;

import com.fightbook.userManager.Entity.BookingData;
import com.fightbook.userManager.Exception.UserBookingException;
import com.fightbook.userManager.dto.PassengerInfo;

public interface UserService {
	
	public List<PassengerInfo> saveorUpdateBooking(List<PassengerInfo> bookingDTO ) throws UserBookingException;
	public List<BookingData> getTicketData(String pnrNumber,Integer type) throws UserBookingException;
	public List<BookingData>getBookingHistroy(String email) throws UserBookingException;
	public PassengerInfo updateBooking(PassengerInfo bookingDTO ) throws UserBookingException;
}
