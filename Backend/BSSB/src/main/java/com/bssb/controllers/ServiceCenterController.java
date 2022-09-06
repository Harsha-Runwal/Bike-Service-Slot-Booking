package com.bssb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.ServiceCenterDao;
import com.bssb.entity.ServiceCenter;

@RestController
@RequestMapping(path="/center")
public class ServiceCenterController {
	
	
	 @Autowired
	 private ServiceCenterDao dao;
	
	 @PostMapping("/register")
	public ServiceCenter register(@RequestBody ServiceCenter  center)
	{
		return  dao.RegisterCenter(center);
	}

}
