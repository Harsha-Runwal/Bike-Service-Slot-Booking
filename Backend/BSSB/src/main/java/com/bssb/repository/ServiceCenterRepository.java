package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository <ServiceCenter,Integer>{

}
