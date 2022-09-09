package com.bssb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
	@PostMapping("/addSlots")
	public ServiceSlotInfoTable addSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		return dao.addSlot(slot);
	}
	
	@PutMapping("/changeNumberOfSlots/{date}/{regNo}/{newSlots}")
	public String changeSlots(@PathVariable String date, @PathVariable int regNo,@PathVariable int newSlots)
	{
		 dao.changeSlots(date,regNo,newSlots);
		 return "successfully changed";
	}
	
	@DeleteMapping("/deleteSlots/{date}/{regNo}")
	public String deleteSlot(@PathVariable String date, @PathVariable int regNo)
	{
		dao.deleteSlot(date, regNo);
		return "successfully deleted";
	}
}
