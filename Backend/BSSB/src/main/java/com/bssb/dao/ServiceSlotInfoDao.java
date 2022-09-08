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
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotUpdate) {
		this.slotRepo = slotUpdate;
	}
	
	public ServiceSlotInfoTable addSlot(ServiceSlotInfoTable slot)
	{
		return slotRepo.save(slot);
	}
}
