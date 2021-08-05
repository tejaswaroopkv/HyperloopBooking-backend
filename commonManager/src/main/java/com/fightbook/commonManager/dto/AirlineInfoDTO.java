package com.fightbook.commonManager.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirlineInfoDTO {
	private Integer airlineId;
	private String airlineName;
	private String logoURL;
//	private String[] flightCodes;
//	private String[] flightCodeIds; 
	private List<FlightCodeInfoDTO> flightCode = new ArrayList<>();
	//private List<FlightCodeInfoDTO>  fightcodeList = new ArrayList<>();
	
	
	public AirlineInfoDTO() {
		super();
	}
	
	/*public AirlineInfoDTO(String code, Integer flightId){
		FlightCodeInfoDTO fcdto = new FlightCodeInfoDTO(code,flightId);
		this.fightcodeList.add(fcdto); 
	}*/
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
	public List<FlightCodeInfoDTO> getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(List<FlightCodeInfoDTO> flightCode) {
		this.flightCode = flightCode;
	}
	@Override
	public String toString() {
		return "AirlineInfoDTO [airlineId=" + airlineId + ", airlineName=" + airlineName + ", logoURL=" + logoURL
				+ ", flightCode=" + flightCode + "]";
	}
	
	
	/*public List<FlightCodeInfoDTO> getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(List<FlightCodeInfoDTO> flightCode) {
		this.flightCode = flightCode;
	}*/
	/*public String[] getFlightCodes() {
		return flightCodes;
	}
	public void setFlightCodes(String[] flightCodes) {
		this.flightCodes = flightCodes;
	}
	
	public String[] getFlightCodeIds() {
		return flightCodeIds;
	}
	public void setFlightCodeIds(String[] flightCodeIds) {
		this.flightCodeIds = flightCodeIds;
	}*/
	/*@Override
	public String toString() {
		return "AirlineInfoDTO [airlineId=" + airlineId + ", airlineName=" + airlineName + ", logoURL=" + logoURL
				+ ", flightCodes=" + Arrays.toString(flightCodes) + ", flightCodeIds=" + Arrays.toString(flightCodeIds)
				+ "]";
	}*/
	

}
