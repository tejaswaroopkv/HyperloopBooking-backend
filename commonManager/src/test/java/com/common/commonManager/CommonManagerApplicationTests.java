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
import org.springframework.test.context.junit4.SpringRunner;

import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Exception.FlightBookingException;
import com.fightbook.commonManager.io.CommonService;
import com.fightbook.commonManager.repository.CommonDAO;
//import org.junit.runner.RunWith;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CommonManagerApplicationTests {
	@Autowired
	private CommonService  service;
	
	@MockBean
	private CommonDAO repository;
	
	@Test
	public void testAirportData() {
		
		try {
			Mockito
				.when(repository.getAirportData())
				.thenReturn(Arrays.asList(new Airport()));
		} catch (FlightBookingException e) {
			e.printStackTrace();
		}
		
		
		List<Airport> airportData;
		try {
			airportData = service.getAirportData();
			System.out.println(airportData);
			System.out.println(airportData.size());
			List<Airport> airports = new ArrayList<>();
			Assertions.assertEquals(airports, airportData);
			Assertions.assertTrue(airports.size()>1);
		} catch (FlightBookingException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
