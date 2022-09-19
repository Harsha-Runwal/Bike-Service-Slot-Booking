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

<<<<<<< HEAD

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonSetter
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
=======
	@ManyToOne(cascade = CascadeType.ALL)
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customerId;

<<<<<<< HEAD
//	@OneToOne(cascade = CascadeType.ALL)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private ServiceSlotInfoTable slotId;
	

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnore
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name="SERVICE_CENTER_ID")
	private ServiceCenter serviceCenterref;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonIgnore
	@OneToOne(mappedBy = "bookingId",cascade= {CascadeType.REFRESH,CascadeType.MERGE})
	private Review review;

	
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
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
