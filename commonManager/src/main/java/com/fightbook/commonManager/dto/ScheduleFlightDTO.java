package com.fightbook.commonManager.dto;

public class ScheduleFlightDTO {

	private Integer id;
	private Integer airlineId;
	private String airlineName;
	private Integer srcid;
	private Integer destid;
	private String sourcePlace;
	private String destinationPlace;
	private String departureDate;
	private String returnDate;
	//private String createdDate;
	private String price;
	private Integer flightCodeId;	
	private Boolean isAvailable;
	private Integer totalSeats;
	
	
	
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

	

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

//	public String getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(String createdDate) {
//		this.createdDate = createdDate;
//	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getFlightCodeId() {
		return flightCodeId;
	}

	public void setFlightCodeId(Integer flightCodeId) {
		this.flightCodeId = flightCodeId;
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

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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

	@Override
	public String toString() {
		return "ScheduleFlightDTO [id=" + id + ", airlineId=" + airlineId + ", airlineName=" + airlineName + ", srcid="
				+ srcid + ", destid=" + destid + ", sourcePlace=" + sourcePlace + ", destinationPlace="
				+ destinationPlace + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", price="
				+ price + ", flightCodeId=" + flightCodeId + ", isAvailable=" + isAvailable + ", totalSeats="
				+ totalSeats + "]";
	}

	

	

	
	
	
	
}
