package com.bssb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bssb.entity.ServiceSlotInfoTable;

@Repository
public interface ServiceSlotInfoRepository extends JpaRepository<ServiceSlotInfoTable, Integer> {
	
	@Query("select c from ServiceSlotInfoTable c where date = :date and regNo = :regNo")
	ServiceSlotInfoTable getByDateAndRegNo(@Param("date") String date,@Param("regNo") int regNo);

	//update service_slot_info_table set remaining_slot = remaining_slot-1 where date='07092022' and reg_no = 126;
	@Modifying
	@Query("update ServiceSlotInfoTable set remainingSlot = remainingSlot-1 where date=:date and regNo =:regNo")
	void updateSlot(@Param("date") String date, @Param("regNo") int regNo);

	//update service_slot_info_table set total_slot = 12, remaining_slot=total_slot where date='07092022' and reg_no = 126;
	@Modifying
	@Query("update ServiceSlotInfoTable set totalSlot =:slots,remainingSlot=:slots where date=:date and regNo =:regNo")
	void changeSlots(@Param("date") String date, @Param("regNo") int regNo, @Param("slots") int slots);
	@Modifying
	@Query("delete from ServiceSlotInfoTable where date = :date and regNo = :regNo")
	void deleteSlot(@Param("date") String date,@Param("regNo") int regNo);
}
