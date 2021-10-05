package com.fightbook.adminManager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fightbook.adminManager.Entity.BookingData;

public interface BookingDataRepository extends JpaRepository<BookingData, Integer>{ 

}
