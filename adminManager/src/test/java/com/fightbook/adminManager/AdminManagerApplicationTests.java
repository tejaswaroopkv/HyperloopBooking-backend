package com.fightbook.adminManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fightbook.adminManager.Exception.FlightBookingException;
import com.fightbook.adminManager.dto.CouponDTO;
import com.fightbook.adminManager.io.AdminService;

@SpringBootTest(classes=AdminManagerApplication.class)
public class AdminManagerApplicationTests {
	
	@Autowired
	private AdminService service;

	CouponDTO couponDTO = new CouponDTO();
	
	@BeforeEach
	public void getCouponDTO() {
		couponDTO.setCouponCode("VACATION");
		couponDTO.setPrice("25$");
	}
	
	@Test
	public void testCouponCodeAlReadyExist() {
		try {
			service.saveorUpdateCoupon(couponDTO);
		} catch (FlightBookingException e) {
			Assertions.assertEquals("Sorry Coupon Code already exist",e.getMessage());
		}
		
		
	}

}
