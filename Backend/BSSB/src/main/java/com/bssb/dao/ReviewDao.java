package com.bssb.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.Review;
import com.bssb.entity.BookingTable;
import com.bssb.entity.ServiceCenter;
import com.bssb.repository.BookingTableRepository;
import com.bssb.repository.ReviewRepository;
import com.bssb.repository.ServiceCenterRepository;
import java.util.List;
import java.util.Optional;
@Component
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepo;

	@Autowired
	private ServiceCenterRepository serviceRepo;
	
	@Autowired
	private BookingTableRepository bookingRepo; 
	

	public ReviewDao() {
		
		
	}
	
	public Review addReview(Review review)
	{
		System.out.println("hello from add review"+review.getRating()+review.getBookingId());
		int bookingId = review.getBookingId().getbookingId();
		System.out.println("bookingId:"+bookingId);
		BookingTable booking = bookingRepo.findById(bookingId).get();
		System.out.println("id from object "+booking.getbookingId());
		review.setBookingId(booking);
		return reviewRepo.save(review);
	}
	
	public Review getReview(int bookingId)
	{
		return reviewRepo.findByBookingId(bookingId);
	}
	
	public List<Review> getByCenter(String city, String centerName)
	{
		ServiceCenter center= serviceRepo.findByCityCenter(city,centerName);
		int centerId = center.getId();
		System.out.println("service center ID"+center.getId());
		List<BookingTable> bookings = bookingRepo.bookingByCenterId(centerId);
		
		List<Review> list = new ArrayList<>();
		for (BookingTable booking : bookings) {
			System.out.println(booking.getbookingId());
			list.add(reviewRepo.getByBooking(booking.getbookingId()));
		}
		return list;
	}
}
