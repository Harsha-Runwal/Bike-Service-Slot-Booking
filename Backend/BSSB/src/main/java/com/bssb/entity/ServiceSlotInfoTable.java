package com.bssb.entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class ServiceSlotInfoTable {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int slotId;
	
	@Column(name="slot_date")
	private String date;
	
	@Column
	private int totalSlot;
	
	@Column
	private int remainingSlot;
	
	// foregin key in slot table regring to sevicecenter table;
	
	@ManyToOne
	@JoinColumn(name="service_center_id")
	private ServiceCenter center;
	
	
	
	public ServiceSlotInfoTable()
	{
		
	}
	
	public ServiceSlotInfoTable(String date, int totalSlot, int remainingSlot,ServiceCenter center) {
	
		 this.date=date;
		this.totalSlot = totalSlot;
		this.remainingSlot = remainingSlot;
		this.center=center;
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

	public int getSlotId() {
		return slotId;
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

	public ServiceCenter getCenter() {
		return center;
	}

	public void setCenter(ServiceCenter center) {
		this.center = center;
	}

	
}
