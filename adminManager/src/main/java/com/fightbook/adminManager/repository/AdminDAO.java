package com.fightbook.adminManager.repository;

import java.io.Serializable;
import java.util.List;

import com.fightbook.adminManager.Entity.Airline;
import com.fightbook.adminManager.Entity.Airport;
import com.fightbook.adminManager.Entity.Coupon;
import com.fightbook.adminManager.Entity.FlightCode;
import com.fightbook.adminManager.Entity.ScheduleFlight;
import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.AirlineDTO;
import com.fightbook.adminManager.dto.AirlineInfoDTO;
import com.fightbook.adminManager.dto.DestinationDTO;
import com.fightbook.adminManager.dto.ScheduleFlightDTO;
import com.fightbook.adminManager.dto.ScheduleFlightData;

public interface AdminDAO {
	public Airline getAirlineByName(String airlineName) throws FlightBookingException;
	public Coupon getCouponByCode(String couponCode) throws FlightBookingException;
	public ScheduleFlight findFlightScheduledAlready(ScheduleFlightDTO scheduleFlightDTO) throws FlightBookingException;
	public List<Object[]> getAirlineInfo() throws FlightBookingException;
	public List<Airport> getAirportData() throws FlightBookingException; 
	public <T extends Serializable> T save(T entity);
	public <T extends Serializable> T merge(T entity);
	public List<Coupon> getCouponData() throws FlightBookingException;
	public List<Object[]> getScheduledFlightData() throws FlightBookingException;
	public <T extends Serializable> T saveData(T entity);
	//public ScheduleFlight

}
