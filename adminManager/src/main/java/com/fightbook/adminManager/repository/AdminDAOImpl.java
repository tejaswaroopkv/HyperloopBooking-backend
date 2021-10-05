package com.fightbook.adminManager.repository;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fightbook.adminManager.Entity.Airline;
import com.fightbook.adminManager.Entity.Airport;
import com.fightbook.adminManager.Entity.Coupon;
import com.fightbook.adminManager.Entity.FlightCode;
import com.fightbook.adminManager.Entity.ScheduleFlight;
import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.AirlineDTO;
import com.fightbook.adminManager.dto.AirlineInfoDTO;
import com.fightbook.adminManager.dto.AirlineResultSet;
import com.fightbook.adminManager.dto.DestinationDTO;
import com.fightbook.adminManager.dto.ScheduleFlightDTO;
import com.fightbook.adminManager.dto.ScheduleFlightData;

@Repository
public class AdminDAOImpl extends BaseRepository implements AdminDAO {
	//private static final ExtLogger log = ExtLogger.create(AdminDAOImpl.class);

	@Override
	public <T extends Serializable> T save(T entity) {
		try {
			return this.saveEntity(entity);
		}catch(Exception e) {
			//log.error("Error in SAVING Data "+ entity.toString());
			return null;
		}
	}

	@Override
	public Airline getAirlineByName(String airlineName) throws FlightBookingException {
		Query query=null;	
		try{
			query = entityManager.createQuery(
				"select al from Airline al where al.airlineName = '" + airlineName +"\'" );
			return query.getResultList()!=null&&query.getResultList().size()!=0&&!query.getResultList().isEmpty()?(Airline)query.getSingleResult():null;
		}catch(Exception e) {
			//log.error("Error in getLevelModuleByModuleId() method ", e);
			throw new FlightBookingException("Something went wrong");
		}
		
	
	}

	@Override
	public Coupon getCouponByCode(String couponCode) throws FlightBookingException {
		Query query=null;	
		try{
			query = entityManager.createQuery(
				"select c from Coupon c where c.couponCode = '" + couponCode +"\'" );
			return query.getResultList()!=null&&query.getResultList().size()!=0&&!query.getResultList().isEmpty()?(Coupon)query.getSingleResult():null;
		}catch(Exception e) {
			//log.error("Error in getLevelModuleByModuleId() method ", e);
			throw new FlightBookingException("Something went wrong");
		}
	}

	@Override
	public ScheduleFlight findFlightScheduledAlready(ScheduleFlightDTO scheduleFlightDTO) throws FlightBookingException {
		Query query=null;
		Date dDate = null;
		Date rDate =null;
		
		Integer srcid = scheduleFlightDTO.getSrcid();
		Integer destid = scheduleFlightDTO.getDestid();
		Integer flightCodeId=scheduleFlightDTO.getFlightCodeId();
		Integer airlineId= scheduleFlightDTO.getAirlineId();
		Boolean isAvailable = scheduleFlightDTO.getIsAvailable();
		String depDate = scheduleFlightDTO.getDepartureDate();
		String returnDate = scheduleFlightDTO.getReturnDate();
		int isActive = isAvailable==true?1:0;
//		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy"); 
//		
//		try {
//			String convertDate = depDate;
//			dDate = (Date)formatter.parse(convertDate);
//			convertDate = returnDate;
//			rDate = (Date)formatter.parse(convertDate);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try{
			query = entityManager.createQuery("select sf from ScheduleFlight sf where sf.srcId=" + srcid + " and sf.desId = "+ destid + 
					"  and sf.flightCodeId =" + flightCodeId + " and sf.airlineId = " + airlineId + " and sf.departureDate=\'"+ depDate + "\' and sf.returnDate=\'"+returnDate + "\' and sf.isAvailable =" + isActive );		
			
			return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(ScheduleFlight)query.getSingleResult():null ;
		}catch(Exception e){
			throw new FlightBookingException("Something went wrong ");
		}
		
		
		
	}

	@Override
	public List<Object[]> getAirlineInfo() throws FlightBookingException {
		try{
		String queryStr = "select al.airline_id as airlineId, al.airline_name as airlineName ,al.logo_url as logoURL, GROUP_CONCAT(DISTINCT f.flight_code" +" \n "+
				 "order by flight_code) as flightCode , GROUP_CONCAT(DISTINCT f.flight_id" + " \n " +
				 "order by flight_id) as flightCodeId from airline al left join flightcode f on al.airline_id=f.airline_id group by  al.airline_id , al.airline_name ,al.logo_url";
								
		
		List<Object[]> results = entityManager.createNativeQuery(queryStr).getResultList();
		
		return results;
		}catch(Exception e){
			throw new FlightBookingException("Something went wrong ");
		}
		
	}

	@Override
	public List<Airport> getAirportData() throws FlightBookingException {
		try{
			Query query =  entityManager.createQuery("select ar from Airport ar");
			return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(List<Airport>)query.getResultList():null;
		}catch(Exception e){
		throw new FlightBookingException("Something went wrong ");
		}
	}

	@Override
	public List<Coupon> getCouponData() throws FlightBookingException {
		try{
			Query query =  entityManager.createQuery("select c from Coupon c");
			return query.getResultList()!=null && query.getResultList().size()!=0 && !query.getResultList().isEmpty()?(List<Coupon>)query.getResultList():null;
		}catch(Exception e){
		throw new FlightBookingException("Something went wrong ");
		}
	}

	@Override
	public List<Object[]> getScheduledFlightData() throws FlightBookingException {
		try{
			String queryStr = "select al.logo_url as logoUrl, al.airline_name as airlineName, f.flight_code as flightCode, ars.city as sourcePlace, ard.city as destinationPlace,"+ "\n"+
							 "sf.price , sf.departure_date as departureDate , sf.return_date as returnDate , sf.total_seats as totalSeats , sf.is_available as isAvailable , sf.id as id , al.airline_id as airlineId ,"+ "\n" +
							  "sf.src_id as srcid ,  sf.dest_id as destid , f.flight_id as flightCodeId" +"\n" +
							 "from schedule_flight sf" + "\n"+ 
							 "join airport ars  on ars.airport_id=sf.src_id" + "\n" + 
							 "join airport ard on ard.airport_id = sf.dest_id  inner join airline al on al.airline_id=sf.airline_id" + "\n"+
							 "inner join flightcode f on f.flight_id=sf.flight_code_id where sf.is_available=1";
			List<Object[]> results =  entityManager.createNativeQuery(queryStr).getResultList();
			
			return results;
		}catch(Exception e){
			throw new FlightBookingException("Something went wrong ");
		}
		
		
	}

	@Override
	public <T extends Serializable> T merge(T entity) {
		try {
			return this.mergeEntity(entity);
		}catch(Exception e) {
			//log.error("Error in SAVING Data "+ entity.toString());
			return null;
		}
	}

	@Override
	public <T extends Serializable> T saveData(T entity) {
		try {
			return this.saveKafkaData(entity);
		}catch(Exception e) {
			//log.error("Error in SAVING Data "+ entity.toString());
			return null;
		}
	}


	


}
