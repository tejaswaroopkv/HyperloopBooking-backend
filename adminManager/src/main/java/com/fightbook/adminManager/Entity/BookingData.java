package com.fightbook.adminManager.Entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger_data")
public class BookingData implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="passenger_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer passengerId;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="parent_passenger_id")
	private Integer parentPassengerId;
	
	@Column(name="trip_type_id")
	private Integer tripType;
	
	@Column(name="airline_id")
	private Integer airlineId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="departure_PNR")
	private String departurePNR;
	
	@Column(name="return_PNR")
	private String returnPNR;
	
	@Column(name="airline_name")
	private String airlineName;
	
	@Column(name="flight_code")
	private String flightCode;
	
	@Column(name="price")
	private String price;
	
	@Column(name="is_cancelled")
	private Boolean isCancelled;
	
	@Column(name="source_place")
	private String sourcePlace;
	
	@Column(name="destination_place")
	private String destinationPlace;
	
	@Column(name="src_id")
	private Integer srcid;
	
	@Column(name="dest_id")
	private Integer destid;

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getParentPassengerId() {
		return parentPassengerId;
	}

	public void setParentPassengerId(Integer parentPassengerId) {
		this.parentPassengerId = parentPassengerId;
	}

	public Integer getTripType() {
		return tripType;
	}

	public void setTripType(Integer tripType) {
		this.tripType = tripType;
	}

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDeparturePNR() {
		return departurePNR;
	}

	public void setDeparturePNR(String departurePNR) {
		this.departurePNR = departurePNR;
	}

	public String getReturnPNR() {
		return returnPNR;
	}

	public void setReturnPNR(String returnPNR) {
		this.returnPNR = returnPNR;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public Integer getSrcid() {
		return srcid;
	}

	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}

	public Integer getDestid() {
		return destid;
	}

	public void setDestid(Integer destid) {
		this.destid = destid;
	}

	@Override
	public String toString() {
		return "BookingData [passengerId=" + passengerId + ", age=" + age + ", parentPassengerId=" + parentPassengerId
				+ ", tripType=" + tripType + ", airlineId=" + airlineId + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", departurePNR=" + departurePNR + ", returnPNR=" + returnPNR
				+ ", airlineName=" + airlineName + ", flightCode=" + flightCode + ", price=" + price + ", isCancelled="
				+ isCancelled + ", sourcePlace=" + sourcePlace + ", destinationPlace=" + destinationPlace + ", srcid="
				+ srcid + ", destid=" + destid + "]";
	}
	
}

