package com.bssb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.BookingTableDao;
import com.bssb.entity.BookingTable;

@RestController
@RequestMapping(path = "/booking")
public class BookingTableController {

	@Autowired
	private BookingTableDao dao;
	
	@PostMapping("/newbooking")
	public BookingTable addBooking(@RequestBody BookingTable booking)
	{
		return dao.addBookingDetails(booking);
	}
}
