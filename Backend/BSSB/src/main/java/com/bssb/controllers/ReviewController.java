package com.bssb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ReviewDao;
import com.bssb.entity.Review;


@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewDao dao;
	
	@GetMapping("/Getreview/{bookingId}")
	public Review Review(@PathVariable int bookingId)
	{
		
		
		
		return dao.getReview(bookingId);
		
	}
	
	@GetMapping("/getAll/{bookingId}")
	public List<Review> Review1(int bookingId) {
		List<Review> li = (List<Review>) dao.getReview(bookingId);
		return li;
		
	}
	
//	@GetMapping("/getAll")
//	 public List<ServiceCenter> serviceCenter()
//	 {
//		 ArrayList<ServiceCenter> list =  (ArrayList<ServiceCenter>) dao.GetAll();
//		 return list;
	// }
}
