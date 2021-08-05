package com.fightbook.userManager.dto;

//import java.lang.Array;
import java.util.ArrayList;
import java.util.List;

public class PassengerInfo {
	private Integer passengerId;
	private String age;
	private Integer parentPassengerId;
	private Integer tripType;
	private Integer couponId;
	private String couponCode;
	private String couponPrice;
	private Integer flightCodeId;
	private String flightCode;
	private Integer airlineId;
	private String airlineName;
	private String name;
	private String email;
	private String contact;
	private String departurePNR;
	private String returnPNR;
	private String price;
	private Boolean isCancelled;
	private Integer srcid;
	private String sourcePlace;
	private Integer destid;
	private String destinationPlace;
	//private Array coPassengers;
	private Boolean isPrimary;
	
	public Integer getParentPassengerId() {
		return parentPassengerId;
	}
	public void setParentPassengerId(Integer parentPassengerId) {
		this.parentPassengerId = parentPassengerId;
	}
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getTripType() {
		return tripType;
	}
	public void setTripType(Integer tripType) {
		this.tripType = tripType;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}
	public Integer getFlightCodeId() {
		return flightCodeId;
	}
	public void setFlightCodeId(Integer flightCodeId) {
		this.flightCodeId = flightCodeId;
	}
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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
	public Integer getSrcid() {
		return srcid;
	}
	public void setSrcid(Integer srcid) {
		this.srcid = srcid;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public Integer getDestid() {
		return destid;
	}
	public void setDestid(Integer destid) {
		this.destid = destid;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	@Override
	public String toString() {
		return "PassengerInfo [passengerId=" + passengerId + ", age=" + age + ", parentPassengerId=" + parentPassengerId
				+ ", tripType=" + tripType + ", couponId=" + couponId + ", couponCode=" + couponCode + ", couponPrice="
				+ couponPrice + ", flightCodeId=" + flightCodeId + ", flightCode=" + flightCode + ", airlineId="
				+ airlineId + ", airlineName=" + airlineName + ", name=" + name + ", email=" + email + ", contact="
				+ contact + ", departurePNR=" + departurePNR + ", returnPNR=" + returnPNR + ", price=" + price
				+ ", isCancelled=" + isCancelled + ", srcid=" + srcid + ", sourcePlace=" + sourcePlace + ", destid="
				+ destid + ", destinationPlace=" + destinationPlace + ", isPrimary=" + isPrimary + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
