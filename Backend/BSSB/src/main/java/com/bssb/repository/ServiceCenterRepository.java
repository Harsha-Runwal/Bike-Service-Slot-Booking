package com.bssb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository <ServiceCenter,Integer>{

	ServiceCenter findByName(String Name);
<<<<<<< HEAD
	ServiceCenter findByRegNo(int regNo);
	ServiceCenter findByEmail(String email);
	
	@Modifying
	@Query("update ServiceCenter set capacity=:slots where registration_no=:regNo")
	void changeSlots(@Param("regNo") int regNo, @Param("slots") int slots);

	
	@Query("select distinct city from ServiceCenter")
	ArrayList<String> getCitiesAll();
	
	@Query("select c from ServiceCenter c")
	ArrayList<ServiceCenter> getCityCenters(@Param("city") String city);
	
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
}
