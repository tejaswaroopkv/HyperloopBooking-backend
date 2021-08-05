package com.fightbook.commonManager.repository;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fightbook.commonManager.Entity.Airport;
import com.fightbook.commonManager.Entity.Coupon;
import com.fightbook.commonManager.Exception.FlightBookingException;



@Repository
public class CommonDAOImpl extends BaseRepository implements CommonDAO {
	

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

	


	


}
