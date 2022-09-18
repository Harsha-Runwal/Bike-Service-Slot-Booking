package com.bssb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	      
	    
	       public ResponseEntity<?> registerCustomer(Customer customer)
	       {
	    	   String email=customer.getEmail();
	    	 Customer user=customerRepo.findByEmail(email);
	    	 System.out.println(user);
	    	 
	    	  if(user==null)
	    	   {
	    	   customerRepo.save(customer);
	    	   return new ResponseEntity<String>("successfully registerd",HttpStatus.OK);
	    	   }
	    	   else
	    	   {
	    		   return new ResponseEntity<String>("user alredy present",HttpStatus.NOT_FOUND);
	    	   }
	       
	       }
	       
	       public ResponseEntity<?> validateSecurityAnswer(String email,String answer)
	       {
	    	   Customer customer=customerRepo.findByEmail(email);
	    	    if(customer!=null)
	    	    {
	    	    	String customerOriginalAns=customer.getSecurityAnswer();
	    	    	if( customerOriginalAns.equals(answer))
	    	    	{
	    	    		System.out.println("send ans"+answer+"databse ans"+customerOriginalAns);
	    	    		return new ResponseEntity<>(HttpStatus.OK);
	    	    	}
	    	    } 
	    	    		return new ResponseEntity<>("inValid ans",HttpStatus.UNAUTHORIZED);
	    	    		
	    	 
	       }
	       public ResponseEntity<?> ResetUserPassword(String email,String password)
	       {
	    	   Customer customer=customerRepo.findByEmail(email);
	    	    customer.setPassword(password);
	    	    customerRepo.save(customer);
	    	   
	    	    return new ResponseEntity<>(HttpStatus.OK);
	    	    
	    	    		
	    	    		
	    	 
	       }
}
