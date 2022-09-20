package com.bssb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_Id")
	private int id;
	@Column
	private int rating;
	@Column
	private String comment;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnore
	@OneToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "BOOKING_ID")
	private BookingTable bookingId;
	
	
	
	public Review()
	{
		
	}
	
	
	public Review(int id, int rating, String comment, BookingTable bookingId) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.bookingId = bookingId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@JsonIgnore
	public BookingTable getBookingId() {
		return bookingId;
	}
	
	@JsonSetter
	public void setBookingId(BookingTable bookingId) {
		this.bookingId = bookingId;
	}
}
