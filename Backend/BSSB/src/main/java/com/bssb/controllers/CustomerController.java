package com.bssb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.http.ResponseEntity;
>>>>>>> c0eae0ca1a201d9c04be18390e4312546d842267
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bssb.dao.CustomerDao;
import com.bssb.entity.Customer;

@CrossOrigin
@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
		@Autowired
	    private CustomerDao dao;
	    
	    @PostMapping("/register")
	    public ResponseEntity <?> register(@RequestBody Customer customer)
	    {
	    	
	    	 
	    	return dao.registerCustomer(customer);
	    }
	    
	    
}
