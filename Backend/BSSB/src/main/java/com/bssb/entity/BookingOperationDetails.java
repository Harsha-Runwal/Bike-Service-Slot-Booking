package com.bssb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class BookingOperationDetails {

	// for a particular booking id user will choose operations and will be stored in this table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//booking id of booking table mapped to booking id of this table
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOKING_ID")
	private BookingTable bookingId;
	
	//multiple operations for one booking entity
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<Operations> operations;
	
	@Column
	private float cost;
	
	@Column
	private boolean status;
	
	public BookingOperationDetails()
	{
		
	}

	public BookingOperationDetails(int id, float cost, boolean status) {
		super();
		this.id = id;
		this.cost = cost;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookingTable getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingTable bookingId) {
		this.bookingId = bookingId;
	}

	public List<Operations> getOperations() {
		return operations;
	}

	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
