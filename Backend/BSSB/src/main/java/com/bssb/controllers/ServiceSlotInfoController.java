package com.bssb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.dtos.PlanDto;
import com.bssb.entity.ServiceSlotInfoTable;

@RestController
@RequestMapping(path = "slotmanagement")
public class ServiceSlotInfoController {

	@Autowired
	private ServiceSlotInfoDao dao;
	
	
	
	@PostMapping("/addSlots")
	public String addSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		dao.addSlot(slot);
		return "successfully Added";
	}
	@GetMapping("/getPlans/{regNo}")
   	public  List<ServiceSlotInfoTable> getSlot(@PathVariable int regNo)
   	{
   		return  dao.getRemaiangingSlot(regNo);
   	}
	
	
//	@DeleteMapping("/deleteSlots/{date}/{regNo}")
//	public String deleteSlot(@PathVariable String date, @PathVariable int regNo)
//	{
//		dao.deleteSlot(date, regNo);
//		return "successfully deleted";
//	}
}
