package com.fightbook.userManager.io;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbook.userManager.Entity.BookingData;
import com.fightbook.userManager.Exception.UserBookingException;
import com.fightbook.userManager.dto.PassengerInfo;
import com.fightbook.userManager.kafka.KafkaController;
import com.fightbook.userManager.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private KafkaController kafka;
	
	private Boolean isSent=false;
	
	@Override
	@Transactional
	public List<PassengerInfo> saveorUpdateBooking(List<PassengerInfo> bookingDTO) throws UserBookingException {
		System.out.println(bookingDTO);
		List<BookingData>bookingList = new ArrayList<>();
		BookingData bookingData = null;
		int primaryId =0;
		for(PassengerInfo passenger : bookingDTO){
			if(passenger.getPassengerId()==null){
				//int rand = (int)(Math.random());
				bookingData = new BookingData();
				bookingData.setName(passenger.getName());
				bookingData.setEmail(passenger.getEmail());
				bookingData.setContact(passenger.getContact());
				bookingData.setAge(Integer.parseInt(passenger.getAge()));
				bookingData.setAirlineId(passenger.getAirlineId());
				bookingData.setAirlineName(passenger.getAirlineName());
				bookingData.setFlightCode(passenger.getFlightCode());
				bookingData.setPrice(passenger.getPrice());
				bookingData.setSrcid(passenger.getSrcid());
				bookingData.setSourcePlace(passenger.getSourcePlace());
				bookingData.setDestid(passenger.getDestid());
				bookingData.setDestinationPlace(passenger.getDestinationPlace());
				bookingData.setTripType(passenger.getTripType());
				bookingData.setDeparturePNR(passenger.getDeparturePNR());
				bookingData.setReturnPNR(passenger.getReturnPNR());
				bookingData.setIsCancelled(false);
				//bookingData.setPassengerId(rand);
				if(passenger.getIsPrimary()){
					bookingData.setParentPassengerId(0);
					bookingData = userDAO.save(bookingData);
					primaryId = bookingData.getPassengerId();
					passenger.setPassengerId(primaryId);
					bookingList.add(bookingData);
				}
				else{
					bookingData.setParentPassengerId(primaryId);
					bookingData = userDAO.save(bookingData);
					passenger.setPassengerId(bookingData.getPassengerId());
					bookingList.add(bookingData);
				}
				/*if(!passenger.getIsPrimary()){
					bookingData.setParentPassengerId(bookingData.getPassengerId());
					bookingData = userDAO.merge(bookingData);
				}*/
				
			}
			/*else{
				bookingData = userDAO.getPassangerById(passenger.getPassengerId());
				bookingData.setIsCancelled(true);
				bookingData = userDAO.merge(bookingData);
			}*/
		}
		this.isSent = kafka.writeData(bookingList);
		if(this.isSent){
			System.out.println("Data sent successfully");
		}
		
		
		return bookingDTO;
	}

	@Override
	@Transactional
	public List<BookingData> getTicketData(String pnrNumber,Integer type) throws UserBookingException {
		// TODO Auto-generated method stub
		List<BookingData> bookingData = null;
		if(type==1){
			 bookingData=userDAO.getPassangerByPNRD(pnrNumber);
		}else{
			 bookingData=userDAO.getPassangerByPNRR(pnrNumber);
		}
		if(bookingData!=null){
			return bookingData;
		}else{
			throw new UserBookingException("Ticket not found");
		}
	}

	@Override
	@Transactional
	public List<BookingData> getBookingHistroy(String email) throws UserBookingException {
		List<BookingData> bookingHistroy = userDAO.getPassangerHistroy(email);
		if(bookingHistroy!=null){
			return bookingHistroy;
		}else{
			throw new UserBookingException("Booking related to this mail was not found");
		}
		
	}

	@Override
	@Transactional
	public PassengerInfo updateBooking(PassengerInfo passenger) throws UserBookingException {
		// TODO Auto-generated method stub
		BookingData bookingData = new BookingData();
		bookingData.setPassengerId(passenger.getPassengerId());
		bookingData.setParentPassengerId(passenger.getParentPassengerId());
		bookingData.setName(passenger.getName());
		bookingData.setEmail(passenger.getEmail());
		bookingData.setContact(passenger.getContact());
		bookingData.setAge(Integer.parseInt(passenger.getAge()));
		bookingData.setAirlineId(passenger.getAirlineId());
		bookingData.setAirlineName(passenger.getAirlineName());
		bookingData.setFlightCode(passenger.getFlightCode());
		bookingData.setPrice(passenger.getPrice());
		bookingData.setSrcid(passenger.getSrcid());
		bookingData.setSourcePlace(passenger.getSourcePlace());
		bookingData.setDestid(passenger.getDestid());
		bookingData.setDestinationPlace(passenger.getDestinationPlace());
		bookingData.setTripType(passenger.getTripType());
		bookingData.setDeparturePNR(passenger.getDeparturePNR());
		bookingData.setReturnPNR(passenger.getReturnPNR());
		bookingData.setIsCancelled(true);
		bookingData = userDAO.merge(bookingData);
		passenger.setIsCancelled(true);
		return passenger;
	}

}
