package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.Plan;


@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer> {
	

}
