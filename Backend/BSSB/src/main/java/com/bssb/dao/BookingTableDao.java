package com.bssb.dao;

<<<<<<< HEAD


import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;

=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.BookingTable;
import com.bssb.repository.BookingTableRepository;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class BookingTableDao {
<<<<<<< HEAD
	
	
	@Autowired
	private ServiceSlotInfoRepository slotRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private ServiceCenterRepository centerRepo;
	
	@Autowired
	private  EmailCustomer emailCustomer;
	@Autowired
	private BookingTableRepository bookingRepo;
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a

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
<<<<<<< HEAD
		System.out.println(bookingObject);
		String customerEmail=bookingObject.getCustomer().getEmail();
		System.out.println(customerEmail);
		 Customer customer=customerRepo.findByEmail(customerEmail);
		 System.out.println(customer);
		 
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
			emailCustomer.sendMail(book);
			return new  ResponseEntity<String>("okk",HttpStatus.OK);

		}
		int bookingId = book.getbookingId();
		return new ResponseEntity<String>("okk",HttpStatus.BAD_REQUEST);
	}
	
	public List<BookingTable> getTodaysBooking(String email ,String date)
	{

		System.out.println(email+" "+date);
		ServiceCenter center = centerRepo.findByEmail(email);
		System.out.println(center.getId());
		
		
		List<BookingTable> list= bookingRepo.getTodaysBooking(center,date);
		System.out.println(list);
		return list;

	}
	
	public List<BookingTable> bookingHistory(String startdate, String enddate, String email)
	{
		ServiceCenter center = centerRepo.findByEmail(email);
		return bookingRepo.bookingHistory(center,startdate,enddate);

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
=======
		
		return bookingRepo.save(booking);
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
	}
	
	
	
	
	
	
}
