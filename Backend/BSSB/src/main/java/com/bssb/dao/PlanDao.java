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
<<<<<<< HEAD
			 String email= plan.getServiceCenterRef().getEmail();
			 ServiceCenter center=centerRepo.findByEmail(email);
			 plan.setServiceCenterRef(center);
=======
			 
			
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
			 return planRepo.save(plan);

		 }

}
