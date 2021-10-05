package com.fightbook.userManager;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fightbook.userManager.Entity.BookingData;
import com.fightbook.userManager.Exception.UserBookingException;
import com.fightbook.userManager.io.UserService;

@SpringBootTest(classes = UserManagerApplication.class)
public class UserManagerApplicationTests {
	@Autowired
	private UserService service;

	@Test
	public void testUserTicketsNotAvailable() {
		String email= "abc@gmail.com";
		List<BookingData> bookings = new ArrayList<>();
		try {
			bookings = service.getBookingHistroy(email);
		} catch (UserBookingException e) {
			Assertions.assertEquals("Booking related to this mail was not found",e.getMessage());
		}
		
	}
	@Test
	public void testUserTicketsAvailable() {
		String email= "test2@gmail.com";
		List<BookingData> bookings = new ArrayList<>();
		try {
			bookings = service.getBookingHistroy(email);
			Assertions.assertTrue(bookings.size()>0);
		} catch (UserBookingException e) {
			Assertions.assertEquals("Booking related to this mail was not found",e.getMessage());
		}
		
	}

}
