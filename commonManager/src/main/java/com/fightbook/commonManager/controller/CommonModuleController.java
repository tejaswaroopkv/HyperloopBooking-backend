package com.fightbook.commonManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fightbook.commonManager.Exception.FlightBookingException;
import com.fightbook.commonManager.dto.AdminConstants;
import com.fightbook.commonManager.dto.AirlineDTO;
import com.fightbook.commonManager.dto.CouponDTO;
import com.fightbook.commonManager.dto.JsonResponse;
import com.fightbook.commonManager.dto.ScheduleFlightDTO;
import com.fightbook.commonManager.io.CommonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("flight")
//@RequestMapping("/common/flight")
public class CommonModuleController extends BaseController {
	@Autowired
	private CommonService adminService;

	
	

	// Get Airline and Fight Codes
	@GetMapping("/getAirlineInfo")
	//@Cacheable(value = "airlineInfo")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getAirlineInfo() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getAirlineInfo(),
					"Flight info successfully returned"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}

	// Get Airport Data
	@GetMapping("/getAirportData")
	//@Cacheable(value = "AirPort-list")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getAirportData() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getAirportData(),
					"Airport data successfully returned"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity(new JsonResponse(AdminConstants.ERROR_MSG, null, ex.getMessage()), HttpStatus.OK);
		}
	}

	// Get Airport Data
	@GetMapping("/getCouponData")
	@Cacheable(value = "coupondata")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<JsonResponse> getCouponData() {
		try {
			return new ResponseEntity(new JsonResponse(AdminConstants.SUCCESS_MSG, adminService.getCouponData(),
					"Coupon data successfully returned"), HttpStatus.OK);
		} catch (Exception ex) {
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
	}
	
	
	

}
