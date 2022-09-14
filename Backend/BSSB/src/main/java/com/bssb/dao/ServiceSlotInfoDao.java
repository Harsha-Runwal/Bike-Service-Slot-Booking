package com.bssb.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bssb.entity.ServiceCenter;
import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.ServiceCenterRepository;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class ServiceSlotInfoDao {

	private ServiceSlotInfoRepository slotRepo;

	private ServiceCenterRepository serviceRepo;
	@Autowired
	private ServiceCenterRepository centerRepo;
	
	public ServiceSlotInfoDao()
	{
		
	}
	
	@Autowired
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotRepo) {
		this.slotRepo = slotRepo;
	}
	/*@Transactional
	public void addSlot(ServiceSlotInfoTable slot)
	{
		ServiceSlotInfoTable slotDetails = slotRepo.save(slot);
		slotRepo.changeSlotForRecent(slotDetails.getTotalSlot(), slotDetails.getBookingId());
	} */
/*
	public ServiceSlotInfoTable slotDetailsOfCenter(String date, int regNo)
	{
		return slotRepo.getByDateAndRegNo(date,regNo);
	}*/

	public void addSlot(ServiceSlotInfoTable slot) {
		
		  int registrationNo=slot.getCenter().getRegNo();
		  ServiceCenter center=centerRepo.findByRegNo(registrationNo);
		  slot.setCenter(center);
		 slot.setRemainingSlot(slot.getTotalSlot());
		 slotRepo.save(slot);
		   
	}
	
	
	  public List<ServiceSlotInfoTable> getRemaiangingSlot(int RegNo)
	  {
		  ServiceCenter center=centerRepo.findByRegNo(RegNo);
		  return center.getSlotList();
	  }
	
}
