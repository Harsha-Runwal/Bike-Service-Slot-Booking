package com.bssb.entity;

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

@Entity
@Table
public class ServiceSlotInfoTable {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int slotId;
	
	@Column
	private String date;
	
	@Column
	private int totalSlot;
	
	@Column
	private int remainingSlot;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SERVICE_CENTER_ID")
	private ServiceCenter serviceCenterId;

	private int regNo;
	
	public ServiceSlotInfoTable()
	{
		
	}
	
	public ServiceSlotInfoTable(String date, int totalSlot, int remainingSlot) {
		super();
		this.date = date;
		this.totalSlot = totalSlot;
		this.remainingSlot = remainingSlot;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalSlot() {
		return totalSlot;
	}

	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}

	public int getRemainingSlot() {
		return remainingSlot;
	}

	public void setRemainingSlot(int remainingSlot) {
		this.remainingSlot = remainingSlot;
	}

	public int getRegNo() {
		return regNo;
	}

	public ServiceCenter getServiceCenterId() {
		return serviceCenterId;
	}
}
