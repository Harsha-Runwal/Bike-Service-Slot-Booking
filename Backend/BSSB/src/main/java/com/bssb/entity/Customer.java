package com.bssb.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER_DETAILS")
public class Customer {
	  
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		@Column(name="CUSTOMER_ID")
		private int id;
		@Column(name="FIRST_NAME")
	    private String firstName;
		@Column(name="LAST_NAME")
		private String LastName;
		@Column(name="EMAIL")
		private String email;
		@Column(name="MOBILE_NO")
		private String mobileNo;
		
		@Column(name="PASSWORD")
		private String password;
		 
		public Customer() {
			
		}
		
		public Customer(String firstName, String lastName, String email, String mobileNo, String password) {
			
			this.firstName = firstName;
			LastName = lastName;
			this.email = email;
			this.mobileNo = mobileNo;
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public String getEmail() {
			return email;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public String getPassword() {
			return password;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
