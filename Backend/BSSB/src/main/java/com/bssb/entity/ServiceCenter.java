package com.bssb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_CENTER_DETAILS")
public class ServiceCenter {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="SERVICE_CENTER_ID")
	private int id;
	private String name;
	private String city;
	private String address;
	private String email;
	@Column(name="CONTACT_NO")
	private String contactNo;
	private String password;
	private int pincode;
	@Column(name="REGISTRATION_NO")
	private int regNo;
	private int capacity;
	
	public ServiceCenter() {
		
	}


	public ServiceCenter( String name, String city, String address, String email, String contactNo,
			String password, int pincode, int regNo, int capacity) {
		
		this.name = name;
		this.city = city;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
		this.pincode = pincode;
		this.regNo = regNo;
		this.capacity = capacity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public int getRegNo() {
		return regNo;
	}


	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	
	
	
	
	
	
	   

}
