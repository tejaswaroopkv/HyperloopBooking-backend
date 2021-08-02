package com.fightbook.adminManager.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flightcode")
public class FlightCode  implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@Column(name="flight_id")
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Integer flightId;

@Column(name="airline_id")
private Integer airlineId;

@Column(name="flight_code")
private String flightCode;

public Integer getFlightId() {
	return flightId;
}

public void setFlightId(Integer flightId) {
	this.flightId = flightId;
}

public Integer getAirlineId() {
	return airlineId;
}

public void setAirlineId(Integer airlineId) {
	this.airlineId = airlineId;
}

public String getFlightCode() {
	return flightCode;
}

public void setFlightCode(String flightCode) {
	this.flightCode = flightCode;
}

@Override
public String toString() {
	return "FlightCode [flightId=" + flightId + ", airlineId=" + airlineId + ", flightCode=" + flightCode + "]";
}




}
