package com.bssb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table
public class Operations {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		private float cost;
		
		@ManyToOne
		private BookingOperationDetails booking;
		
		public Operations() {
			 System.out.println("object is being ceated");
		}
		
		public Operations(String name, float cost) {
			
			this.name = name;
			this.cost = cost;
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
		public float getCost() {
			return cost;
		}
		public void setCost(float cost) {
			this.cost = cost;
		}

		public BookingOperationDetails getBooking() {
			return booking;
		}

		public void setBooking(BookingOperationDetails booking) {
			this.booking = booking;
		}
		
		
}
