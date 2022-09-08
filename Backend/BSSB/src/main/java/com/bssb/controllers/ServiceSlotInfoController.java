package com.bssb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.entity.ServiceSlotInfoTable;

@RestController
@RequestMapping(path = "slotmanagement")
public class ServiceSlotInfoController {

	@Autowired
	private ServiceSlotInfoDao dao;
	
	@PostMapping("/todaysSlot")
	public ServiceSlotInfoTable addSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		return dao.addSlot(slot);
	}
}
