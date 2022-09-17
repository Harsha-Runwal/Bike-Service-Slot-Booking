package com.bssb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	Review findByBookingId(int id);
	
		
	
	
}
