package com.bssb.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.PlanDao;
import com.bssb.entity.Plan;

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
