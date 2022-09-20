package com.bssb.dtos;

import java.io.InputStream;

import org.apache.catalina.connector.Response;

import com.bssb.entity.ServiceCenter;

public class PlanDto {

	private String name;
	private String description;
	private String image;
	private float cost;
	private ServiceCenter serviceCenterRef;

	public ServiceCenter getServiceCenterRef() {
		return serviceCenterRef;
	}
	public void setServiceCenterRef(ServiceCenter serviceCenterRef) {
		this.serviceCenterRef = serviceCenterRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}





}