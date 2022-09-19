package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceSlotInfoTable;

@Repository
public interface ServiceSlotInfoRepository extends JpaRepository<ServiceSlotInfoTable, Integer> {
	
}
