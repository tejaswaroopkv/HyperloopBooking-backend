package com.fightbook.adminManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.AdminConstants;
import com.fightbook.adminManager.dto.AirlineDTO;
import com.fightbook.adminManager.dto.CouponDTO;
import com.fightbook.adminManager.dto.JsonResponse;
import com.fightbook.adminManager.dto.ScheduleFlightDTO;
import com.fightbook.adminManager.io.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin
@RequestMapping("flight")
//@RequestMapping("admin/flight")
public class AdminModuleController extends BaseController {
	@Autowired
	private AdminService adminService;

	// Add Airline
	@PostMapping("/saveAirline")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> saveOrUpdateAirline(@RequestBody AirlineDTO airlineDTO) {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG,
					adminService.saveorUpdateAirline(airlineDTO), "Airline saved successfully"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}

	// Add Coupon
	@PostMapping("/saveCoupon")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> saveOrUpdateCoupon(@RequestBody CouponDTO couponDTO) {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG,
					adminService.saveorUpdateCoupon(couponDTO), "Coupon saved successfully"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, couponDTO, ex.getMessage()),
					HttpStatus.OK);
		}
	}

	// Add/Schedule Flight
	@PostMapping("/addFlight")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> saveOrUpdateFlight(@RequestBody ScheduleFlightDTO scheduleFlightDTO) {
		try {
			return new ResponseEntity(
					new JsonResponse(AdminConstants.SUCCESS_MSG,
							adminService.saveorUpdateScheduleFlight(scheduleFlightDTO), "Flight added successfully"),
					HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, scheduleFlightDTO, ex.getMessage()),
					HttpStatus.OK);
		}
	}
	
	//Get Passenger Bookings
	@GetMapping("/getPassengerBookings")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getPassengerBookings() {
		try {
			return new ResponseEntity(
					new JsonResponse(AdminConstants.SUCCESS_MSG,
							adminService.getPassengerBookings(), "Flight added successfully"),
					HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()),
					HttpStatus.OK);
		}
	}
	

	// Get Airline and Fight Codes
/*	@GetMapping("/getAirlineInfo")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getAirlineInfo() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getAirlineInfo(),
					"Flight info successfully returned"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}

	// Get Airport Data
	@GetMapping("/getAirportData")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getAirportData() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getAirportData(),
					"Airport data successfully returned"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}

	// Get Airport Data
	@GetMapping("/getCouponData")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getCouponData() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getCouponData(),
					"Coupon data successfully returned"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}
	
	
	@GetMapping("/getScheduledFlightData")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getScheduledFlightData() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getScheduleFlightData(),
					"Scheduled Flight Data successfully returned"), HttpStatus.OK);
		} catch (FlightBookingException ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}*/
	
	
	

}
