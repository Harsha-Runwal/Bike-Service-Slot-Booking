package com.bssb.dao;

<<<<<<< HEAD
=======


import java.util.ArrayList;
import java.util.Date;
>>>>>>> 30696f5dbd9228a4ec55c6c2e3de37543e16883a
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bssb.entity.BookingTable;
import com.bssb.entity.Customer;
import com.bssb.entity.ServiceCenter;
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
	
	public List<BookingTable> getTodaysBooking(String email ,String date)
	{
<<<<<<< HEAD
		System.out.println(email+" "+date);
		ServiceCenter center = centerRepo.findByEmail(email);
		System.out.println(center.getId());
		List<BookingTable> list2=new ArrayList<>();
		BookingTable b1=new BookingTable();
		b1.setmodelNo("hjqwhdk");
		list2.add(b1);
		
		List<BookingTable> list= bookingRepo.getTodaysBooking(center,date);
		System.out.println(list);
		return list;
=======
		ServiceCenter center = centerRepo.findByEmail(email);
		return bookingRepo.getTodaysBooking(center.getId(),date);
>>>>>>> c0eae0ca1a201d9c04be18390e4312546d842267
	}
	
	public List<BookingTable> bookingHistory(String startdate, String enddate, String email)
	{
		ServiceCenter center = centerRepo.findByEmail(email);
<<<<<<< HEAD
		return bookingRepo.bookingHistory(center,startdate,enddate);
=======
		return bookingRepo.bookingHistory(center.getId(),startdate,enddate);
>>>>>>> c0eae0ca1a201d9c04be18390e4312546d842267
	}
	
	public BookingTable updateBooking(BookingTable updatedBooking)
	{
		int bookingId = updatedBooking.getbookingId();
		Optional<BookingTable> booking=bookingRepo.findById(bookingId);
		booking.get().setBookingDate(updatedBooking.getBookingDate());
		booking.get().setmodelNo(updatedBooking.getmodelNo());
		booking.get().setstatus(updatedBooking.getstatus());
		booking.get().settotalCost(updatedBooking.gettotalCost());
		booking.get().setvehicleRegNo(updatedBooking.getvehicleRegNo());
		
		BookingTable upBooking = bookingRepo.save(booking.get());
		return upBooking;
	}
	
	public String deleteBooking(int bookingId)
	{
		bookingRepo.deleteById(bookingId);
		return "deleted";
	}
}
