package com.bssb.dao;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bssb.entity.BookingTable;
import com.bssb.entity.Customer;
import com.bssb.entity.ServiceCenter;
import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.BookingTableRepository;
import com.bssb.repository.CustomerRepository;
import com.bssb.repository.ServiceCenterRepository;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class BookingTableDao {
	private BookingTableRepository bookingRepo;
	@Autowired
	private ServiceSlotInfoRepository slotRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ServiceCenterRepository centerRepo;
	
	public BookingTableDao()
	{
		
	}
	
	@Autowired
	public BookingTableDao(BookingTableRepository bookingRepo)
	{
		
		this.bookingRepo = bookingRepo;
	}
	
	public int addBookingDetails(BookingTable bookingObject)
	{
		String customerEmail=bookingObject.getCustomer().getEmail();
		 Customer customer=customerRepo.findByEmail(customerEmail);
		 System.out.println(customer.getEmail()+"cusomer name"+customer.getFirstName());
		 bookingObject.setCustomer(customer);
		 int registrtaionNumber=bookingObject.getServiceCenterref().getRegNo();
		 ServiceCenter center=centerRepo.findByRegNo(registrtaionNumber);
		 bookingObject.setServiceCenterref(center);
		 System.out.println("printing the service center object "+ center.getName());
		BookingTable book = bookingRepo.save(bookingObject);
		if(book!=null)
		{
			System.out.println("objcet saved ");
			
			 String bookingDate=book.getBookingDate();
			slotRepo.upDateSlot(center, bookingDate);
		}
		int bookingId = book.getbookingId();
		return bookingId;
	}
}
