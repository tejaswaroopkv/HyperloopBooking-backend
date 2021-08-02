package com.fightbook.adminManager.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="schedule_flight")
public class ScheduleFlight implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name="airline_id")
	private Integer airlineId;
	
	@Column(name="src_id")
	private Integer srcId;
	
	@Column(name="dest_id")
	private Integer desId;
	
	@Column(name="flight_code_id")
	private Integer flightCodeId;
	
	@Column(name="price")
	private String price;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="departure_date")
	private String departureDate;

	@Column(name="return_date")
	//@Temporal(TemporalType.DATE)
	private String returnDate;
	
	@Column(name="total_seats")
	private Integer totalSeats;
	
	
	
	@Column(name="is_available")
	private Boolean isAvailable;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public Integer getSrcId() {
		return srcId;
	}

	public void setSrcId(Integer srcId) {
		this.srcId = srcId;
	}

	public Integer getDesId() {
		return desId;
	}

	public void setDesId(Integer desId) {
		this.desId = desId;
	}

	public Integer getFlightCodeId() {
		return flightCodeId;
	}

	public void setFlightCodeId(Integer flightCodeId) {
		this.flightCodeId = flightCodeId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "ScheduleFlight [id=" + id + ", airlineId=" + airlineId + ", srcId=" + srcId + ", desId=" + desId
				+ ", flightCodeId=" + flightCodeId + ", price=" + price + ", departureDate=" + departureDate
				+ ", returnDate=" + returnDate + ", totalSeats=" + totalSeats + ", isAvailable=" + isAvailable + "]";
	}

	
	
	
	
	
	
	
	

}
