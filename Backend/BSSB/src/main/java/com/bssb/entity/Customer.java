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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


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
		@Column
		private String role;
		@Column(name="security_question")
		private String securityAnswer;

		@Column(name="PASSWORD")
		private String password;
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonIgnore
		@OneToMany(mappedBy = "customer",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH })
		private List <BookingTable> bookingtbaleref;

		public Customer() {

		}
		
		public Customer(String firstName, String lastName, String email, String mobileNo, String password) {
			
			this.firstName = firstName;
			LastName = lastName;
			this.email = email;
			this.mobileNo = mobileNo;
			this.password = password;
		}
		
		
		
		public String getSecurityAnswer() {
			return securityAnswer;
		}

		public void setSecurityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
		}
		public int getId() {
			return id;
		}
		public String getFirstName() {
			return firstName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}


		@JsonIgnore
		public List<BookingTable> getBookingtbaleref() {
			return bookingtbaleref;
		}

		public void setBookingtbaleref(List<BookingTable> bookingtbaleref) {
			this.bookingtbaleref = bookingtbaleref;
		}

		public void setId(int id) {
			this.id = id;
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

		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
					+ ", mobileNo=" + mobileNo + ", role=" + role + ", password=" + password + ", bookingtbaleref="
					+ bookingtbaleref + "]";
		}



}  