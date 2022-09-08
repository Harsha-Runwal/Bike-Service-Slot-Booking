package com.bssb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository <ServiceCenter,Integer>{

	ServiceCenter findByName(String Name);
}
