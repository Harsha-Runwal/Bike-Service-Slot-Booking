package com.bssb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ServiceSlotInfoDao;
import com.bssb.entity.ServiceSlotInfoTable;

<<<<<<< HEAD
@CrossOrigin
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
@RestController
@RequestMapping(path = "slotmanagement")
public class ServiceSlotInfoController {

	@Autowired
	private ServiceSlotInfoDao dao;
	
	@PostMapping("/todaysSlot")
	public ServiceSlotInfoTable addSlot(@RequestBody ServiceSlotInfoTable slot)
	{
<<<<<<< HEAD
		dao.addSlot(slot);
		return "successfully Added";

	}

	
	//get remaining slot from regNo and date

	@GetMapping("/getSlot/{regNo}")
   	public  List<ServiceSlotInfoTable> getSlot(@PathVariable int regNo)
   	{
   		return  dao.getRemaiangingSlot(regNo);
   	}

	
//AKSHAY
	@GetMapping("/getSlots/{regNo}/{date}")
    public int getSlot(@PathVariable int regNo,@PathVariable String date)
    {
		System.out.println("entereddddd");
     return  dao.slotDetailsOfCenter(date, regNo);
    }
	

		

//	@DeleteMapping("/deleteSlots/{date}/{regNo}")
//	public String deleteSlot(@PathVariable String date, @PathVariable int regNo)
//	{
//		dao.deleteSlot(date, regNo);
//		return "successfully deleted";
//	}
=======
		return dao.addSlot(slot);
	}
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
}
