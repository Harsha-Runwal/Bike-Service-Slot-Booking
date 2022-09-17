package com.bssb.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bssb.dao.PlanDao;
import com.bssb.dtos.PlanDto;
import com.bssb.entity.Plan;
@CrossOrigin
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
	   	@GetMapping("/getPlans/{regNo}")
	   	public  List<PlanDto> getPlanList(@PathVariable int regNo)
	   	{
	   		return dao.getPlan(regNo);
	   	}
	  

}
