package com.fightbook.commonManager.dto;

public class FlightCodeInfoDTO {
	private String flightCode;
	private Integer flightCodeId;
	

	
	public FlightCodeInfoDTO() {
		super();
	}

	/*public FlightCodeInfoDTO(String code, Integer flightId) {
		this.flightCode = code;
		this.flightCodeId =flightId;
	}*/

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

	@Override
	public String toString() {
		return "FlightCodeInfoDTO [flightCode=" + flightCode + ", flightCodeId=" + flightCodeId + "]";
	}

	
	

}
