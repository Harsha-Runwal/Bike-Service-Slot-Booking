package com.bssb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.BookingTableDao;
import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.entity.BookingTable;

@RestController
@RequestMapping(path = "/booking")
public class BookingTableController {

	@Autowired
	private BookingTableDao dao;
	
	@Autowired
	private ServiceSlotInfoDao slotDao;
	
	//send new booking entry with slotdetails, this will return remaining slot value which should reflect on slot available info... 
	@PostMapping("/newbooking")
	public BookingTable addBooking(@RequestBody BookingTable booking)
	{
		return dao.addBookingDetails(booking);
	}
	
//	@GetMapping("/bookinghistory/{startdate}/{enddate}/{regNo}")
//	public List<BookingTable> getHistory(@PathVariable String startdate, @PathVariable String enddate)
//	{
//		
//	}
}

