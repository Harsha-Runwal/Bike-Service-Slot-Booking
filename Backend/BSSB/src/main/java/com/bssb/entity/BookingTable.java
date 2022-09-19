package com.bssb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private int slotId;

	@Column
	private boolean status;

	@Column
	private float totalCost;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customerId;

	public int getbookingId() {
		return bookingId;
	}

	public BookingTable(int bookingId, String vehicleRegNo, String modelNo, int slotId, boolean status,
			float totalCost) {
		super();
		this.vehicleRegNo = vehicleRegNo;
		this.modelNo = modelNo;
		this.slotId = slotId;
		this.status = status;
		this.totalCost = totalCost;
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

	public int getslotId() {
		return slotId;
	}

	public void setslotId(int slotId) {
		this.slotId = slotId;
	}

	public boolean isstatus() {
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

}
