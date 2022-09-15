

package com.bssb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.dtos.ServiceCenterDto;
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
	  
	  public List<ServiceCenterDto> GetAll()
	  {
		  List <ServiceCenter> centerList= centerRepo.findAll();
		  List<ServiceCenterDto> centerDtoList=new ArrayList<>();
		  for(ServiceCenter center:centerList)
		  {
			 ServiceCenterDto dto=new ServiceCenterDto();
			   dto.setName(center.getName());
			   dto.setEmail(center.getEmail());
			   dto.setCity(center.getCity());
			   dto.setAddress(center.getAddress());
			   dto.setRegNo(center.getRegNo());
			    centerDtoList.add(dto);
		  }
		  return centerDtoList;
	  }
	  
	  public ServiceCenterDto getByName(String name)
	  {  
		   ServiceCenter center=centerRepo.findByName(name);
		   ServiceCenterDto centerDto=new ServiceCenterDto();
		    centerDto.setName(center.getName());
		    centerDto.setRegNo(center.getRegNo());
		    centerDto.setEmail(center.getEmail());
		    centerDto.setAddress(center.getAddress());
		    centerDto.setCity(center.getCity());
		    return centerDto;
	  }
	  
	  public String updateCenterDetails(ServiceCenter serviceCenter)
	  {
		  Optional<ServiceCenter> center = centerRepo.findById(serviceCenter.getId());
		  return "center details updated";
	  }
	  
}
