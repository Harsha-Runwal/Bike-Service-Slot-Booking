package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bssb.entity.BookingTable;
import com.bssb.entity.ServiceSlotInfoTable;
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
	
	public int addBookingDetails(BookingTable booking)
	{
		BookingTable book = bookingRepo.save(booking);
		int bookingId = book.getbookingId();
		return bookingId;
	}
}
