package com.bssb.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class ServiceSlotInfoDao {

	private ServiceSlotInfoRepository slotRepo;

	public ServiceSlotInfoDao()
	{
		
	}
	
	@Autowired
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotUpdate) {
		this.slotRepo = slotUpdate;
	}
	
	public ServiceSlotInfoTable addSlot(ServiceSlotInfoTable slot)
	{
		return slotRepo.save(slot);
	}
	
	public ServiceSlotInfoTable slotDetailsOfCenter(String date, int regNo)
	{
		return slotRepo.getByDateAndRegNo(date,regNo);
	}
	@Transactional
	public void updateSlotFromDateReg(String date, int regNo)
	{
		slotRepo.updateSlot(date, regNo);
	}
	
	@Transactional
	 public void changeSlots(String date,int regNo,int slots)
	 {
		  slotRepo.changeSlots(date,regNo,slots);
	 }
	 
	@Transactional
	 public void deleteSlot(String date, int regNo)
	 {
		 slotRepo.deleteSlot(date, regNo);
	 }
}
