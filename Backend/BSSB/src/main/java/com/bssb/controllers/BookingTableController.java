package com.bssb.controllers;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bssb.dao.BookingTableDao;
import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.entity.BookingTable;
import com.bssb.entity.ServiceSlotInfoTable;
@RestController
@RequestMapping(path = "/booking")
public class BookingTableController {

	@Autowired
	private BookingTableDao dao;
	@Autowired
	private ServiceSlotInfoDao slotDao;
	
	//will return bookingId, store it in slotUpdate json object. 
	@PostMapping("/newbooking")
	public int addBooking(@RequestBody BookingTable booking)
	{
		 System.out.println("request coming here");
		return dao.addBookingDetails(booking);
	}
	
	//send json object of service_slot_info_table including bookingId , this will return remaining slots
	@PostMapping("/newSlot")
	public int addNewSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		 slotDao.addSlot(slot);
		 return slotDao.getRemainingSlots(slot.getBookingId());
	}
	
//	@GetMapping("/bookinghistory/{startdate}/{enddate}/{regNo}")
//	public List<BookingTable> getHistory(@PathVariable String startdate, @PathVariable String enddate)
//	{
//		
//	}
}