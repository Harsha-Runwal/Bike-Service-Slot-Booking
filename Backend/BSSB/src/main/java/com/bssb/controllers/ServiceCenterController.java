package com.bssb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ServiceCenterDao;
import com.bssb.entity.ServiceCenter;
<<<<<<< HEAD
import com.bssb.entity.ServiceSlotInfoTable;

@CrossOrigin
=======

>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
@RestController
@RequestMapping(path="/center")
public class ServiceCenterController {
	 @Autowired
	 private ServiceCenterDao dao;
	
	 @PostMapping("/register")
	public ServiceCenter register(@RequestBody ServiceCenter  center)
	{
		return dao.RegisterCenter(center);
	}
	 
	 @GetMapping("/getAll")
	 public List<ServiceCenter> serviceCenter()
	 {
		 return dao.GetAll();
	 }
	 
	 @GetMapping("/getCenterByName/{name}")
	 public ServiceCenter center(@PathVariable String name)
	 {
		 return dao.getByName(name);
	 }
<<<<<<< HEAD
	 
	 @PutMapping("/updateServiceCenter")
	 public String updateCenter(@RequestBody ServiceCenter center)
	 {
		return dao.updateCenterDetails(center); 
	 }
	/* //ddmmyyyy
	 @GetMapping("/getSlotDetails/{name}/{date}")
	 public ServiceSlotInfoTable slotDetailsForDate(@PathVariable String name, @PathVariable String date)
	 {
		 ServiceCenter center = dao.getByName(name);
		 return slotDao.slotDetailsOfCenter(date, center.getRegNo());
	 }   */
	 
	 
	 //Akshay
	 @GetMapping("/getCities")
	 public ArrayList<String> getAllCities()
	 {
		 return dao.getCities();
	 }
	 
	 @GetMapping("/getCenterByCity/{city}")
	 public ArrayList<String> getCenterByCity(@PathVariable String city)
	 {
		 return dao.getCenters(city);
	 }
	 
	 
	 
	 
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
}
