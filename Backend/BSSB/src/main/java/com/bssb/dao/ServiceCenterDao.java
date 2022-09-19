package com.bssb.dao;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.ServiceCenter;
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
<<<<<<< HEAD
	  
	  //service center can update capacity, contact details, email,name
	  public String updateCenterDetails(ServiceCenter serviceCenter)
	  {
		  Optional<ServiceCenter> center = centerRepo.findById(serviceCenter.getId());
		  center.get().setCapacity(serviceCenter.getCapacity());
		  center.get().setContactNo(serviceCenter.getContactNo());
		  center.get().setEmail(serviceCenter.getEmail());
		  center.get().setName(serviceCenter.getName());
		  centerRepo.save(center.get());
		  return "center details updated";
	  }
	  
	  
	  //AKhsay
	  public ArrayList<String> getCities()
	  {
		  return centerRepo.getCitiesAll();
	  }
	  public ArrayList<String> getCenters(String city)
	  {
		  ArrayList<String> nameList=new ArrayList<String>();
		  ArrayList<ServiceCenter> serCenter=centerRepo.getCityCenters(city);
		  for(int i=0;i<serCenter.size();i++)
		  {
			  if(serCenter.get(i).getCity().contains(city))
					  {
				  			nameList.add(serCenter.get(i).getName());
					  }
		  }
		  return nameList;
	  }
	  
=======
>>>>>>> 05e9354aef8ac9d3a2eb827eaac14fec2d26cd6a
}
