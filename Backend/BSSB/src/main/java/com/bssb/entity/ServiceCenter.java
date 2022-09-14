package com.bssb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Column
	private String role;
	
	private int capacity;
	@OneToMany(mappedBy="center",cascade= {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	private List<ServiceSlotInfoTable> slotList;
	
	@OneToMany(mappedBy="serviceCenterref",cascade= {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	private List<BookingTable> bookingtableref;
	
	@OneToMany(mappedBy="serviceCenterRef",cascade= {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	 private List<Plan> plans;
	
	
	public ServiceCenter() {
		
	}


	public ServiceCenter( String name, String city, String address, String email, String contactNo,
			String password, int pincode, int regNo, int capacity,List<Plan> plans) {
		
		this.name = name;
		this.city = city;
		this.address = address;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
		this.pincode = pincode;
		this.regNo = regNo;
		this.capacity = capacity;
		this.plans=plans;
	}


	public int getId() {
		return id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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


	public List<BookingTable> getBookingtableref() {
		return bookingtableref;
	}


	public void setBookingtableref(List<BookingTable> bookingtableref) {
		this.bookingtableref = bookingtableref;
	}


	public List<ServiceSlotInfoTable> getSlotList() {
		return slotList;
	}


	public void setSlotList(List<ServiceSlotInfoTable> slotList) {
		this.slotList = slotList;
	}


	public List<Plan> getPlans() {
		return plans;
	}


	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}


	
	
	
	
	
}
