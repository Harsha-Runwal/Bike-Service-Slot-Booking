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
	
	  //Akshay  
		/*
		 * public int getRemaiangingSlot(int RegNo,String date) {
		 * System.out.println(RegNo+" "+date); ServiceCenter
		 * center=centerRepo.findByRegNo(RegNo); int id=center.getId(); return
		 * slotRepo.getRemainingSlots(id, date); }
		 */
	  
	  public int slotDetailsOfCenter(String date, int regNo)
		{
		  ServiceCenter center=centerRepo.findByRegNo(regNo);
		  int id=center.getId();
		  ServiceSlotInfoTable ss= slotRepo.getByDateAndRegNo(date,id);
		  
		  return ss.getRemainingSlot();
		}
	  
	  
	
}
