package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bssb.entity.BookingTable;
import com.bssb.repository.BookingTableRepository;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class BookingTableDao {
	private BookingTableRepository bookingRepo;
	private ServiceSlotInfoRepository serviceSlot;
	
	public BookingTableDao()
	{
		
	}
	
	@Autowired
	public BookingTableDao(BookingTableRepository bookingRepo)
	{
		this.bookingRepo = bookingRepo;
	}
	
	public BookingTable addBookingDetails(BookingTable booking)
	{
		return bookingRepo.save(booking);
	}
}
