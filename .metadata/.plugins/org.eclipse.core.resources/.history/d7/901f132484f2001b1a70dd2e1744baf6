package com.fightbook.adminManager.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airline")

//	@SqlResultSetMapping(name="UserBusinessFunctionMapping", classes = {
//			@ConstructorResult(targetClass=UserBusinessFunctionResultSet.class,
//					columns ={
//							@ColumnResult(name="module_id", type=Integer.class),
//							@ColumnResult(name="module_name", type=String.class),
//							@ColumnResult(name="module_cd", type=String.class),
//							@ColumnResult(name="category", type=Integer.class),
//							@ColumnResult(name="category_name", type=String.class),
//							@ColumnResult(name="domain", type=Integer.class),
//							@ColumnResult(name="domain_name", type=String.class),
//							@ColumnResult(name="module_type", type=Integer.class),
//							@ColumnResult(name="type_name", type=String.class),
//							@ColumnResult(name="is_secured", type=String.class),
//							@ColumnResult(name="Permission", type=String.class),
//							@ColumnResult(name="Param", type=String.class),
//
//			})
//@SqlResultSetMapping(
//        name = "AuthorMapping",
//        entities = @EntityResult(
//                entityClass = Author.class,
//                fields = {
//                    @FieldResult(name = "id", column = "authorId"),
//                    @FieldResult(name = "firstName", column = "firstName"),
//                    @FieldResult(name = "lastName", column = "lastName"),
//                    @FieldResult(name = "version", column = "version")}))


public class Airline implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="airline_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer airlineId;
	@Column(name="airline_name")
	private String airlineName;
	@Column(name="logo_url")
	private String logoURL;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="address")
	private String address;
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
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", airlineName=" + airlineName + ", logoURL=" + logoURL
				+ ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}
	
	
	
	
}
