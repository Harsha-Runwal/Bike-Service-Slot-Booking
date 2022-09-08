package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bssb.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan,Integer> {
	

}
