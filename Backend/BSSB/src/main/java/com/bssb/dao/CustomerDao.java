package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bssb.entity.Customer;
import com.bssb.repository.CustomerRepository;

@Component
public class CustomerDao {
	      private CustomerRepository customerRepo;
	      public  CustomerDao()
	      {
	    	  
	      }
	      @Autowired
	      public CustomerDao(CustomerRepository  customerRepo)
	      {
	    	  this.customerRepo=customerRepo;
	      }
	      
	    
	       public Customer registerCustomer(Customer customer)
	       {
	    	    return customerRepo.save(customer);
	       }
}
