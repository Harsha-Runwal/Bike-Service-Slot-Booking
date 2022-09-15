package com.bssb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bssb.entity.BookingTable;
import com.bssb.entity.ServiceCenter;

@Repository
public interface BookingTableRepository extends JpaRepository<BookingTable, Integer> {
    
	
	//get todays booking details of center
	@Query("select c from BookingTable c where c.serviceCenterref=:serviceCenterref and c.bookingDate=:bookingDate")
	List<BookingTable> getTodaysBooking(@Param("serviceCenterref") ServiceCenter serviceCenterref, @Param("bookingDate") String bookingDate);
	
	
	
	//get booking history
	@Query("select c from BookingTable c where c.serviceCenterref=:centerId and c.bookingDate in(:startdate,:enddate)")
	List<BookingTable> bookingHistory(@Param("centerId") ServiceCenter centerId, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
