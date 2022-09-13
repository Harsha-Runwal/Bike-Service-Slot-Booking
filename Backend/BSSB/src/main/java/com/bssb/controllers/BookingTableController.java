package com.bssb.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bssb.dao.BookingTableDao;
import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.entity.BookingTable;
import com.bssb.entity.Customer;
import com.bssb.entity.ServiceCenter;
import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.CustomerRepository;
import com.bssb.repository.ServiceCenterRepository;
import com.bssb.securityConfigration.CustomJwtAuthenticationFilter;
import com.bssb.securityConfigration.JwtUtil;
@RestController
@RequestMapping(path = "/booking")
public class BookingTableController {

	@Autowired
	private BookingTableDao dao;
	@Autowired
	private ServiceSlotInfoDao slotDao;
	
	
	//will return bookingId, store it in slotUpdate json object. 
	@PostMapping("/newbooking")
	public int addBooking(@RequestBody BookingTable bookingObject)
	{
		//String jwtToken =  authObjet.extractJwtFromRequest(request);
		//UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken)
		
		return dao.addBookingDetails(bookingObject);
	}
	
	//send json object of service_slot_info_table including bookingId , this will return remaining slots
	//@PostMapping("/newSlot")
/*	public int addNewSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		 slotDao.addSlot(slot);
		 return slotDao.getRemainingSlots(slot.getBookingId());
	}*/
	
//	@GetMapping("/bookinghistory/{startdate}/{enddate}/{regNo}")
//	public List<BookingTable> getHistory(@PathVariable String startdate, @PathVariable String enddate)
//	{
//		
//	}
}