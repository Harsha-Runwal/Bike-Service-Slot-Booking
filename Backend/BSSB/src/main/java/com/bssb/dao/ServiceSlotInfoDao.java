package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.ServiceSlotInfoRepository;

@Component
public class ServiceSlotInfoDao {

	private ServiceSlotInfoRepository slotRepo;

	public ServiceSlotInfoDao()
	{
		
	}
	
	@Autowired
<<<<<<< HEAD
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

		System.out.println("hiiii"+slot.getTotalSlot());

		String email=slot.getCenter().getEmail();
		  ServiceCenter center=centerRepo.findByEmail(email);
		  slot.setCenter(center);
		 slot.setRemainingSlot(slot.getTotalSlot());
		 slotRepo.save(slot);


		   
	

=======
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotUpdate) {
		this.slotRepo = slotUpdate;
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
	}
	
	public ServiceSlotInfoTable addSlot(ServiceSlotInfoTable slot)
	{
		return slotRepo.save(slot);
	}
}
