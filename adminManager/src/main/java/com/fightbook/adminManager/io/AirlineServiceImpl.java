package com.fightbook.adminManager.io;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fightbook.adminManager.Entity.Airline;
import com.fightbook.adminManager.Entity.Airport;
import com.fightbook.adminManager.Entity.BookingData;
import com.fightbook.adminManager.Entity.Coupon;
import com.fightbook.adminManager.Entity.FlightCode;
import com.fightbook.adminManager.Entity.ScheduleFlight;
import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.AirlineDTO;
import com.fightbook.adminManager.dto.AirlineInfoDTO;
import com.fightbook.adminManager.dto.CouponDTO;
import com.fightbook.adminManager.dto.FlightCodeInfoDTO;
import com.fightbook.adminManager.dto.ScheduleFlightDTO;
import com.fightbook.adminManager.dto.ScheduleFlightData;
import com.fightbook.adminManager.repository.AdminDAO;
import com.fightbook.adminManager.repository.BookingDataRepository;
//import com.mysql.cj.util.DnsSrv.SrvRecord;

@Service
public class AirlineServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private BookingDataRepository bookingRepo;
	
	private static final String TOPIC = "passengerData";

	@Override
	@Transactional
	public AirlineDTO saveorUpdateAirline(AirlineDTO airlineDTO) throws FlightBookingException {
		Airline airline = null;
		if (adminDAO.getAirlineByName(airlineDTO.getAirlineName()) != null) {
			airline = adminDAO.getAirlineByName(airlineDTO.getAirlineName());
			airlineDTO.setAirlineId(airline.getAirlineId());
		} else {
			airline = new Airline();
			BeanUtils.copyProperties(airlineDTO, airline);
			airline = adminDAO.save(airline);
			airlineDTO.setAirlineId(airline.getAirlineId());
		}
		this.saveorUpdateFlight(airlineDTO, airline.getAirlineId());

		return airlineDTO;
	}

	private void saveorUpdateFlight(AirlineDTO airlineDTO, Integer airlineId) {
		FlightCode flight = new FlightCode();
		flight.setFlightCode(airlineDTO.getFlightCode());
		flight.setAirlineId(airlineId);
		// BeanUtils.copyProperties(airlineDTO,flight);
		adminDAO.save(flight);

	}

	@Override
	@Transactional
	public CouponDTO saveorUpdateCoupon(CouponDTO couponDTO) throws FlightBookingException {
		Coupon coupon = null;
		coupon = adminDAO.getCouponByCode(couponDTO.getCouponCode());
		if (coupon != null) {
			throw new FlightBookingException("Sorry Coupon Code already exist");
		} else {
			coupon = new Coupon();
			BeanUtils.copyProperties(couponDTO, coupon);
			adminDAO.save(coupon);
			couponDTO.setId(coupon.getId());
			return couponDTO;
		}
	}

	@Override
	@Transactional
	public ScheduleFlightDTO saveorUpdateScheduleFlight(ScheduleFlightDTO scheduleFlightDTO)
			throws FlightBookingException {
		if(scheduleFlightDTO.getId()==null){
			ScheduleFlight scheduleFlight = null;
			scheduleFlight = adminDAO.findFlightScheduledAlready(scheduleFlightDTO);
			if (scheduleFlight != null) {
				throw new FlightBookingException("Flight Scheduled Already");
			} else {
				scheduleFlight = new ScheduleFlight();
				scheduleFlight.setSrcId(scheduleFlightDTO.getSrcid());
				scheduleFlight.setDesId(scheduleFlightDTO.getDestid());
				scheduleFlight.setFlightCodeId(scheduleFlightDTO.getFlightCodeId());
				scheduleFlight.setPrice(scheduleFlightDTO.getPrice());
				scheduleFlight.setAirlineId(scheduleFlightDTO.getAirlineId());
				scheduleFlight.setIsAvailable(scheduleFlightDTO.getIsAvailable());
				scheduleFlight.setDepartureDate(scheduleFlightDTO.getDepartureDate());
				scheduleFlight.setReturnDate(scheduleFlightDTO.getReturnDate());
				scheduleFlight.setTotalSeats(scheduleFlightDTO.getTotalSeats());
				scheduleFlight = adminDAO.save(scheduleFlight);
				/*
				 * try { DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
				 * String convertDate = scheduleFlightDTO.getDepatureDate(); Date
				 * departureDate = (Date)formatter.parse(convertDate); convertDate =
				 * scheduleFlightDTO.getReturnDate(); Date returnDate =
				 * (Date)formatter.parse(convertDate);
				 * scheduleFlight.setDepartureDate(departureDate);
				 * scheduleFlight.setReturnDate(returnDate); scheduleFlight =
				 * adminDAO.save(scheduleFlight); //scheduleFlight.getCreatedDate()
				 * //if(scheduleFlightDTO.getReturnDate()!="")//need to check this
				 * condition while saving passengerinfo //and also booking-component
				 * value="" in html } catch (ParseException e) { throw new
				 * FlightBookingException("Sorry Something went wrong"); }
				 */
				return scheduleFlightDTO;
			}
		}else{
			ScheduleFlight scheduleFlight = new ScheduleFlight();
			scheduleFlightDTO.setIsAvailable(false);
			BeanUtils.copyProperties(scheduleFlightDTO, scheduleFlight);
			scheduleFlight.setSrcId(scheduleFlightDTO.getSrcid());
			scheduleFlight.setDesId(scheduleFlightDTO.getDestid());
			scheduleFlight.setId(scheduleFlightDTO.getId());
			scheduleFlight = adminDAO.merge(scheduleFlight);
			return scheduleFlightDTO;
		}
	}

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
				

				/*
				 * for(int i=0;i<Array.getLength(codes);i++){ FlightCodeInfoDTO
				 * fcdto = new FlightCodeInfoDTO();
				 * fcdto.setFlightCode(codes[i]); fightcodeList.add(fcdto); }
				 */
				// airlineInfo.setFlightCode(fightcodeList);
				/*airlineInfo.setFlightCodes(codes);*/
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
	@KafkaListener(topics = TOPIC, groupId = "group_id", containerFactory = "userKafkaListenerFactory")
	public void getDataFromKafkaAndPutItIntoDB(BookingData ticket) {
		bookingRepo.save(ticket);
		System.out.println("Kafka data saved to DB..!");
	}

	@Override
	public List<BookingData> getPassengerBookings() throws FlightBookingException {
		return bookingRepo.findAll();
	}

}
