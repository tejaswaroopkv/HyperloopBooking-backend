package com.fightbook.userManager.repository;

import java.io.Serializable;
import java.util.List;

import com.fightbook.userManager.Entity.BookingData;

public interface UserDAO {
	public <T extends Serializable> T save(T entity);
	public <T extends Serializable> T merge(T entity);
	public List<BookingData> getPassangerByPNRD(String pnrNumber);
	public List<BookingData> getPassangerByPNRR(String pnrNumber);
	public List<BookingData> getPassangerHistroy(String email);
}
