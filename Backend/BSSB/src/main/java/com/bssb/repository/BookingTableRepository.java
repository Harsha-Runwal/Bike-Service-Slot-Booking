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
	@Query("select c from BookingTable c where serviceCenterref.id=:centerId and bookingDate=:date")
	List<BookingTable> getTodaysBooking(@Param("centerId") int centerId, @Param("date") String date);

    
	
	

	
	//get booking history
	@Query("select c from BookingTable c where c.serviceCenterref.id=:centerId and c.bookingDate in(:startdate,:enddate)")
	List<BookingTable> bookingHistory(@Param("centerId") int centerId, @Param("startdate") String startdate, @Param("enddate") String enddate);
}
