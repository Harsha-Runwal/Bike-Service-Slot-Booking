package com.bssb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository <ServiceCenter,Integer>{

	

	ServiceCenter findByName(String Name);
	ServiceCenter findByRegNo(int regNo);
	
	@Modifying
	@Query("update ServiceCenter set capacity=:slots where registration_no=:regNo")
	void changeSlots(@Param("regNo") int regNo, @Param("slots") int slots);

	ServiceCenter findByEmail(String email);
}
