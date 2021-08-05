package com.fightbook.commonManager.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 @Entity
 @Table(name="airport")
public class Airport implements Serializable {
	 private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="airport_id")
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private Integer airportId;
		
		@Column(name="airport_name")
		private String airportName;
		
		@Column(name="code")
		private String code;
		
		@Column(name="city")
		private String city;
		
		@Column(name="state")
		private String state;
		
		@Column(name="country")
		private String country;

		public Integer getAirportId() {
			return airportId;
		}

		public void setAirportId(Integer airportId) {
			this.airportId = airportId;
		}

		public String getAirportName() {
			return airportName;
		}

		public void setAirportName(String airportName) {
			this.airportName = airportName;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public String toString() {
			return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", code=" + code + ", city="
					+ city + ", state=" + state + ", country=" + country + "]";
		}
		
		
		
		

}
