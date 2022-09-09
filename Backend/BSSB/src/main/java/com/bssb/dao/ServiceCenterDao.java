

package com.bssb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.ServiceCenter;
import com.bssb.entity.ServiceSlotInfoTable;
import com.bssb.repository.ServiceCenterRepository;

@Component
public class ServiceCenterDao {
	
	
	  private ServiceCenterRepository centerRepo;
	   
	  public ServiceCenterDao() {
		  
	  }
	  @Autowired
	  public ServiceCenterDao(ServiceCenterRepository centerRepo) {
		   this.centerRepo=centerRepo; 
	  	}
	  
	  public ServiceCenter RegisterCenter(ServiceCenter center)
	  {
		   return centerRepo.save(center);
	  }
	  
	  public List<ServiceCenter> GetAll()
	  {
		  return centerRepo.findAll();
	  }
	  
	  public ServiceCenter getByName(String name)
	  {  
		 return centerRepo.findByName(name);
	  }
	  
	  
//	  ServiceCenter center = new ServiceCenter();
//	  center = centerRepo.findByName(name);
//	  
//	  ServiceSlotInfoTable slotDetails = new ServiceSlotInfoTable();
//	  ServiceSlotInfoDao dao = new ServiceSlotInfoDao();
//	  
//	  dao.slotDetailsOfCenter(,center.getRegNo())
}
