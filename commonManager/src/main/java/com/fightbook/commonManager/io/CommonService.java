package com.fightbook.commonManager.io;

import java.util.List;

import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Entity.Coupon;
import com.fightbook.commonManager.Exception.FlightBookingException;
import com.fightbook.commonManager.dto.AirlineDTO;
import com.fightbook.commonManager.dto.AirlineInfoDTO;
import com.fightbook.commonManager.dto.CouponDTO;
import com.fightbook.commonManager.dto.ScheduleFlightDTO;
import com.fightbook.commonManager.dto.ScheduleFlightData;

public interface CommonService {
	public List<AirlineInfoDTO> getAirlineInfo() throws FlightBookingException;
	public List<Airport> getAirportData() throws FlightBookingException;
	public List<Coupon> getCouponData() throws FlightBookingException;
	public List<ScheduleFlightData> getScheduleFlightData() throws FlightBookingException;

}
