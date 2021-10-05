package com.fightbook.userManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fightbook.userManager.Exception.UserBookingException;
import com.fightbook.userManager.dto.PassengerInfo;
import com.fightbook.userManager.dto.JsonResponse;
import com.fightbook.userManager.dto.UserConstants;
import com.fightbook.userManager.io.UserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("flight")
//@RequestMapping("/user/flight")
public class UserManagerController {
	@Autowired
	private UserService userService;
	
	//User Booking Flight
	@PostMapping("/bookFlight")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> saveOrUpdateBooking(@RequestBody List<PassengerInfo> bookingDataDTO) {
		try {
			return new ResponseEntity(new JsonResponse(UserConstants.SUCCESS_MSG,
					userService.saveorUpdateBooking(bookingDataDTO), "Flight Booked successfully"), HttpStatus.OK);
		} catch (UserBookingException ex) {
			return new ResponseEntity(new JsonResponse(UserConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}
	
	@PostMapping("/deleteBooking")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> UpdateBooking(@RequestBody PassengerInfo bookingDataDTO) {
		try {
			return new ResponseEntity(new JsonResponse(UserConstants.SUCCESS_MSG,
					userService.updateBooking(bookingDataDTO), "Booking Cancelled successfully"), HttpStatus.OK);
		} catch (UserBookingException ex) {
			return new ResponseEntity(new JsonResponse(UserConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}
	
	
	//Get user ticket
	@GetMapping("/getTicket")
	//@Cacheable(value = "ticketData")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getTicket(@RequestParam("pnr") String pnrNumber, @RequestParam("type") Integer type) {
		try {
			return new ResponseEntity(new JsonResponse(UserConstants.SUCCESS_MSG,
					userService.getTicketData(pnrNumber,type), "Flight ticket returned successfully"), HttpStatus.OK);
		} catch (UserBookingException ex) {
			return new ResponseEntity(new JsonResponse(UserConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}
	@GetMapping("/getBookingHistroy")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getBookingHistroy(@RequestParam("email")String email) {
		try {
			return new ResponseEntity(new JsonResponse(UserConstants.SUCCESS_MSG,
					userService.getBookingHistroy(email), "Booking Histroy returned successfully"), HttpStatus.OK);
		} catch (UserBookingException ex) {
			return new ResponseEntity(new JsonResponse(UserConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}
}
