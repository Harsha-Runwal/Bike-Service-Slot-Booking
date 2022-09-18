package com.bssb.dao;





import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bssb.emailsender.EmailCustomer;
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
	
	@Autowired
	private  EmailCustomer emailCustomer;

	
	public BookingTableDao()
	{
		
	}
	
	@Autowired
	public BookingTableDao(BookingTableRepository bookingRepo)
	{
		
		this.bookingRepo = bookingRepo;
	}
	
	public ResponseEntity<String> addBookingDetails(BookingTable bookingObject)
	{
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
		
		
		
		return bookingRepo.getTodaysBooking(center.getId(),date);

	}
	
	public List<BookingTable> bookingHistory(String startdate, String enddate, String email)
	{
		ServiceCenter center = centerRepo.findByEmail(email);

		return bookingRepo.bookingHistory(center.getId(),startdate,enddate);

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
