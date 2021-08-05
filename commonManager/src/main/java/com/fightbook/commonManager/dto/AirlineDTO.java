package com.fightbook.commonManager.dto;



public class AirlineDTO {
	private Integer airlineId;

	private String airlineName;
	
	private String logoURL;
	
	private String contactNumber;
	
	private String address;
	
	private String flightCode;

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

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Override
	public String toString() {
		return "AirlineDTO [airlineId=" + airlineId + ", airlineName=" + airlineName + ", logoURL=" + logoURL
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", flightCode=" + flightCode + "]";
	}


	

	
	
	

}
