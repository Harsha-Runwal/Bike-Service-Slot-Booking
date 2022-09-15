package com.bssb.entity;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class BookingTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
	private int bookingId;

	@Column
	private String vehicleRegNo;

	@Column
	private String modelNo;

	@Column
	private boolean status;

	@Column
	private float totalCost;
	@Column
	private String bookingDate;
	
	private String planName;

	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

//	@OneToOne(cascade = CascadeType.ALL)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private ServiceSlotInfoTable slotId;
	

	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name="SERVICE_CENTER_ID")
	private ServiceCenter serviceCenterref;
	
	public int getbookingId() {
		return bookingId;
	}

	public BookingTable(int bookingId, String vehicleRegNo, String modelNo, boolean status,
			float totalCost, Customer customer,ServiceCenter serviceCenterref,String bookingDate) {
		super();
		this.vehicleRegNo = vehicleRegNo;
		this.modelNo = modelNo;
		this.status = status;
		this.totalCost = totalCost;
		this.customer=customer;
		
		this.bookingDate=bookingDate;
	}

	public BookingTable() {

	}

	public String getvehicleRegNo() {
		return vehicleRegNo;
	}

	public void setvehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getmodelNo() {
		return modelNo;
	}

	public void setmodelNo(String modelNo) {
		this.modelNo = modelNo;
	}
//	public ServiceSlotInfoTable getSlotId() {
//		return slotId;
//	}
//
//	public void setSlotId(ServiceSlotInfoTable slotId) {
//		this.slotId = slotId;
//	}
	public boolean getstatus() {
		return status;
	}

	public void setstatus(boolean status) {
		this.status = status;
	}

	public float gettotalCost() {
		return totalCost;
	}

	public void settotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public ServiceCenter getServiceCenterref() {
		return serviceCenterref;
	}

	public void setServiceCenterref(ServiceCenter serviceCenterref) {
		this.serviceCenterref = serviceCenterref;
	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	

	
	

}
