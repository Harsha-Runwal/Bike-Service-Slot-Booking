package com.bssb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bssb.entity.BookingTable;

@Repository
public interface BookingTableRepository extends JpaRepository<BookingTable, Integer> {

	
}
