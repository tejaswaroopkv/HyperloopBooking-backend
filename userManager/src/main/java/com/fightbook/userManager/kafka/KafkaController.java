package com.fightbook.userManager.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fightbook.userManager.Entity.BookingData;
import com.fightbook.userManager.dto.PassengerInfo;

@Component
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, BookingData> kafkaTemplate;
	private static final String TOPIC = "passengerData";
	
	public boolean writeData(List<BookingData> passengerTickets) {
		System.out.println("Sending Data to Kafka..!");
		int tickets = passengerTickets.size();
		int count = 0;
		
		for (BookingData ticket : passengerTickets) {
			kafkaTemplate.send(TOPIC, ticket);
			count++;
		}
		return tickets == count;
	}
}
