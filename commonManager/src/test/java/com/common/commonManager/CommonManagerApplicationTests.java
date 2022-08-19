package com.common.commonManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

import com.fightbook.commonManager.CommonManagerApplication;
import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Entity.Coupon;
import com.fightbook.commonManager.Exception.FlightBookingException;
import com.fightbook.commonManager.dto.AirlineDTO;
import com.fightbook.commonManager.dto.AirlineInfoDTO;
import com.fightbook.commonManager.io.CommonService;
import com.fightbook.commonManager.repository.CommonDAO;

@SpringBootTest(classes = CommonManagerApplication.class)
public class CommonManagerApplicationTests {
	@Autowired
	private CommonService service;

	@MockBean
	private CommonDAO repository;

	List<Airport> airportList = new ArrayList<>();
	List<AirlineInfoDTO> airlineinfoList = new ArrayList<>();
	List<Coupon> couponList = new ArrayList<>();

	@Test
	public void testAirportData() {
		try {
			Mockito.when(repository.getAirportData()).thenReturn(Arrays.asList(new Airport()));
			List<Airport> airports = service.getAirportData();
			Assertions.assertTrue(airports.size() > 0);
			Assertions.assertNotEquals(airportList, airports);
			System.out.println(airports);
		} catch (FlightBookingException e) {
			e.getMessage();
		}
	}

	@Test
	public void testAirportDataException() {
		try {
			Mockito.when(repository.getAirportData()).thenThrow(new FlightBookingException("Something went wrong"));
			List<Airport> airports = service.getAirportData();
		} catch (FlightBookingException e) {
			e.getMessage();
			Assertions.assertEquals("Something went wrong",e.getMessage());

		}
	}



	@Test
	public void testCouponData() {
		try {
			Mockito.when(repository.getCouponData()).thenReturn(Arrays.asList(new Coupon()));
			List<Coupon> coupons = service.getCouponData();
			Assertions.assertTrue(coupons.size() > 0);
			Assertions.assertNotEquals(couponList, coupons);
			System.out.println(coupons);
		} catch (FlightBookingException e) {
			e.getMessage();

		}
	}

}
