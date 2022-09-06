package com.bssb.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.Plan;
import com.bssb.repository.PlanRepository;

@Component
public class PlanDao {
	
		private PlanRepository planRepo;
		
		public PlanDao()
		{
			
		}
		
		@Autowired
		public PlanDao(PlanRepository planRepo)
		{
			this.planRepo=planRepo;
		}
		
		 public Plan addPlan(Plan plan)
		 {
			 
			
			 return planRepo.save(plan);
		 }

}
