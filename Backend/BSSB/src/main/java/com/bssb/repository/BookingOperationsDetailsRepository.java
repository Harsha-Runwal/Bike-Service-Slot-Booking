package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bssb.entity.BookingOperationDetails;

@Repository
public interface BookingOperationsDetailsRepository extends JpaRepository<BookingOperationDetails, Integer> {

}
