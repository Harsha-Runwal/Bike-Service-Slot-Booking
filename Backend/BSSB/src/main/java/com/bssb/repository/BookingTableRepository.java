package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.BookingTable;

@Repository
public interface BookingTableRepository extends JpaRepository<BookingTable, Integer> {

<<<<<<< HEAD
    //get todays booking details of center
	@Query("select c from BookingTable c where serviceCenterref.id=:centerId and bookingDate=:date")
	List<BookingTable> getTodaysBooking(@Param("centerId") int centerId, @Param("date") String date);

	
	//get todays booking details of center
	@Query("select c from BookingTable c where c.serviceCenterref=:serviceCenterref and c.bookingDate=:bookingDate")
	List<BookingTable> getTodaysBooking(@Param("serviceCenterref") ServiceCenter serviceCenterref, @Param("bookingDate") String bookingDate);
	
	

	//get booking history
	@Query("select c from BookingTable c where c.serviceCenterref=:centerId and c.bookingDate in(:startdate,:enddate)")
	List<BookingTable> bookingHistory(@Param("centerId") ServiceCenter centerId, @Param("startdate") String startdate, @Param("enddate") String enddate);
	
	
	
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
}
