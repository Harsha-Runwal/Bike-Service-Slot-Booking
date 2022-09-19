package com.bssb.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;
import com.bssb.dao.PlanDao;
import com.bssb.dtos.PlanDto;
import com.bssb.entity.Plan;


import com.bssb.imageControl.FileService;


@CrossOrigin
=======

import com.bssb.dao.PlanDao;
import com.bssb.entity.Plan;

>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
@RestController
@RequestMapping("/plan")
public class PlanController {
	
	   @Autowired
	   private PlanDao dao;
	   
	   	@PostMapping("/add")
	     public Plan add(@RequestBody Plan plan)
	     {
	    	  
	    	 return dao.addPlan(plan);
	    	 
	     }
	  

}
