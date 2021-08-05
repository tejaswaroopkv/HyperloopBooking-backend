package com.fightbook.commonManager.dto;

public class ScheduleFlightData {
	private String logoUrl;
	private String airlineName;
	private String flightCode;
	private String sourcePlace;
	private String destinationPlace;
	private String departureDate;
	private String returnDate;
	private String price;
	private Integer totalSeats;
	private Byte isAvailable;
	private Integer id;
	private Integer airlineId;
	private Integer srcid;
	private Integer destid;
	private Integer flightCodeId;	
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Byte getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Byte isAvailable) {
		this.isAvailable = isAvailable;
	}
	
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
	public Integer getFlightCodeId() {
		return flightCodeId;
	}
	public void setFlightCodeId(Integer flightCodeId) {
		this.flightCodeId = flightCodeId;
	}
	@Override
	public String toString() {
		return "ScheduleFlightData [logoUrl=" + logoUrl + ", airlineName=" + airlineName + ", flightCode=" + flightCode
				+ ", sourcePlace=" + sourcePlace + ", destinationPlace=" + destinationPlace + ", departureDate="
				+ departureDate + ", returnDate=" + returnDate + ", price=" + price + ", totalSeats=" + totalSeats
				+ ", isAvailable=" + isAvailable + ", id=" + id + ", airlineId=" + airlineId + ", srcid=" + srcid
				+ ", destid=" + destid + ", flightCodeId=" + flightCodeId + "]";
	}
	
	

}
