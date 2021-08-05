package com.fightbook.commonManager.io;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Entity.Coupon;
import com.fightbook.commonManager.Exception.FlightBookingException;
import com.fightbook.commonManager.dto.AirlineInfoDTO;
import com.fightbook.commonManager.dto.FlightCodeInfoDTO;
import com.fightbook.commonManager.dto.ScheduleFlightData;
import com.fightbook.commonManager.repository.CommonDAO;






@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CommonDAO adminDAO;

	

	@Override
	public List<AirlineInfoDTO> getAirlineInfo() throws FlightBookingException {
		List<Object[]> obj = adminDAO.getAirlineInfo();
		List<FlightCodeInfoDTO> fightcodeList = null;
		List<AirlineInfoDTO> airlineInfoList = new ArrayList<>();
		for (Object[] data : obj) {
			if (data != null) {
				AirlineInfoDTO airlineInfo = new AirlineInfoDTO();
				fightcodeList = new ArrayList<>();
				Integer id = (Integer) data[0];
				airlineInfo.setAirlineId((Integer) data[0]);
				airlineInfo.setAirlineName((String) data[1]);
				airlineInfo.setLogoURL((String) data[2]);
				String[] codes = ((String) data[3]).split(",");
				String[] flightCodeIdList = ((String) data[4]).split(",");
				
				 for(int i=0;i<Array.getLength(codes);i++){ 
					 FlightCodeInfoDTO
					 fcdto = new FlightCodeInfoDTO();
					 fcdto.setFlightCode(codes[i]); 
					 fcdto.setFlightCodeId(Integer.parseInt(flightCodeIdList[i]));
					 fightcodeList.add(fcdto);
				}
				

				
				airlineInfo.setFlightCode(fightcodeList);
				airlineInfoList.add(airlineInfo);
			}
		}

		return airlineInfoList;
	}

	@Override
	public List<Airport> getAirportData() throws FlightBookingException {
		List<Airport> airport = adminDAO.getAirportData();
		return airport;
	}

	@Override
	public List<Coupon> getCouponData() throws FlightBookingException {
		List<Coupon> coupon = adminDAO.getCouponData();
		return coupon;
	}

	@Override
	public List<ScheduleFlightData> getScheduleFlightData() throws FlightBookingException {
		List<Object[]> obj = adminDAO.getScheduledFlightData();
		List<ScheduleFlightData> scheduleFlightList = new ArrayList<>();
		obj.forEach((ele)->{
			if(ele!=null){
				ScheduleFlightData  scheduleFlightData = new ScheduleFlightData();
				
					scheduleFlightData.setLogoUrl((String)ele[0]);
					scheduleFlightData.setAirlineName((String) ele[1]);
					scheduleFlightData.setFlightCode((String) ele[2]);		
					scheduleFlightData.setSourcePlace((String) ele[3]);
					scheduleFlightData.setDestinationPlace((String) ele[4]);
					scheduleFlightData.setPrice((String)ele[5]);
					scheduleFlightData.setDepartureDate((String) ele[6]);
					scheduleFlightData.setReturnDate((String)ele[7]);	
					scheduleFlightData.setTotalSeats((Integer)ele[8]);
					scheduleFlightData.setIsAvailable((Byte) ele[9]);
					scheduleFlightData.setId((Integer)ele[10]);
					scheduleFlightData.setAirlineId((Integer)ele[11]);
					scheduleFlightData.setSrcid((Integer)ele[12]);
					scheduleFlightData.setDestid((Integer)ele[13]);
					scheduleFlightData.setFlightCodeId((Integer)ele[14]);
					
				
				scheduleFlightList.add(scheduleFlightData);
			}
		});
		
		
		return scheduleFlightList;
	}

}
