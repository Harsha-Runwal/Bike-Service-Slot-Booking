package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.Review;
import com.bssb.repository.ReviewRepository;

import antlr.collections.List;
@Component
public class ReviewDao {

	private ReviewRepository reviewRepo;

	@Autowired
	public ReviewDao(ReviewRepository reviewRepo) {
		
		this.reviewRepo = reviewRepo;
	}

	public ReviewDao() {
		
		
	}
	
	public Review newReview(Review review)
	{
		return reviewRepo.save(review);
	}
	public Review getReview(int bookingId)
	{
		return reviewRepo.findByBookingId(bookingId);
	}
	
	
}
