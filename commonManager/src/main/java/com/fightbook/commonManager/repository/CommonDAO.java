package com.fightbook.commonManager.repository;

import java.io.Serializable;
import java.util.List;

import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Entity.Coupon;
import com.fightbook.commonManager.Exception.FlightBookingException;



public interface CommonDAO {
	
	public List<Object[]> getAirlineInfo() throws FlightBookingException;
	public List<Airport> getAirportData() throws FlightBookingException; 
	public List<Coupon> getCouponData() throws FlightBookingException;
	public List<Object[]> getScheduledFlightData() throws FlightBookingException;

}
