package com.fightbook.adminManager.io;

import java.util.List;

import com.fightbook.adminManager.Entity.Airport;
import com.fightbook.adminManager.Entity.BookingData;
import com.fightbook.adminManager.Entity.Coupon;
import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.AirlineDTO;
import com.fightbook.adminManager.dto.AirlineInfoDTO;
import com.fightbook.adminManager.dto.CouponDTO;
import com.fightbook.adminManager.dto.ScheduleFlightDTO;
import com.fightbook.adminManager.dto.ScheduleFlightData;

public interface AdminService {
	public AirlineDTO saveorUpdateAirline(AirlineDTO airlineDTO ) throws FlightBookingException;
	public CouponDTO saveorUpdateCoupon(CouponDTO couponDTO ) throws FlightBookingException;
	public ScheduleFlightDTO saveorUpdateScheduleFlight(ScheduleFlightDTO scheduleFlightDTO) throws FlightBookingException;
	public List<AirlineInfoDTO> getAirlineInfo() throws FlightBookingException;
	public List<Airport> getAirportData() throws FlightBookingException;
	public List<Coupon> getCouponData() throws FlightBookingException;
	public List<ScheduleFlightData> getScheduleFlightData() throws FlightBookingException;
	public List<BookingData>getPassengerBookings() throws FlightBookingException;

}
