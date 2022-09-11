package com.bssb.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.ServiceCenterRepository;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class ServiceSlotInfoDao {

	private ServiceSlotInfoRepository slotRepo;

	private ServiceCenterRepository serviceRepo;
	
	public ServiceSlotInfoDao()
	{
		
	}
	
	@Autowired
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotUpdate) {
		this.slotRepo = slotUpdate;
	}
	@Transactional
	public void addSlot(ServiceSlotInfoTable slot)
	{
		ServiceSlotInfoTable slotDetails = slotRepo.save(slot);
		slotRepo.changeSlotForRecent(slotDetails.getTotalSlot(), slotDetails.getBookingId());
	}
	
	public int getRemainingSlots(int bookingId)
	{
		ServiceSlotInfoTable slot=slotRepo.getRemainingSlots(bookingId);
		return slot.getRemainingSlot();
	}
	public ServiceSlotInfoTable slotDetailsOfCenter(String date, int regNo)
	{
		return slotRepo.getByDateAndRegNo(date,regNo);
	}
	
	@Transactional
	 public void changeSlots(int regNo,int slots)
	 {
		  serviceRepo.changeSlots(regNo,slots);
	 }
}
