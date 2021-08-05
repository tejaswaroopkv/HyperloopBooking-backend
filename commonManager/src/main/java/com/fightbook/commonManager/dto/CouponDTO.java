package com.fightbook.commonManager.dto;

public class CouponDTO {
	private Integer id;
	private String couponCode;
	private String price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CouponDTO [id=" + id + ", couponCode=" + couponCode + ", price=" + price + "]";
	}
	

}
