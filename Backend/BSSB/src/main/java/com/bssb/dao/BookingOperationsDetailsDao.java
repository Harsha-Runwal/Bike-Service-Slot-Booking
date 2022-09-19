package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.BookingOperationDetails;
import com.bssb.repository.BookingOperationsDetailsRepository;

@Component
public class BookingOperationsDetailsDao {

	private BookingOperationsDetailsRepository bookOperRepo;
	
	public BookingOperationsDetailsDao() 
	{
		
	}
	
	@Autowired
	public BookingOperationsDetailsDao(BookingOperationsDetailsRepository bookOperRepo)
	{
		this.bookOperRepo = bookOperRepo;
	}
	
	public BookingOperationDetails newOperInBooking(BookingOperationDetails bookOperDetails)
	{
		return bookOperRepo.save(bookOperDetails);
	}
}
