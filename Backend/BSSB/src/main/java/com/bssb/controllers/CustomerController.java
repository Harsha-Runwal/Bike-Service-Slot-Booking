package com.bssb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	    @PostMapping("/forgetPaswword/{email}/{securityAnswer}")
	    public ResponseEntity<?> validateAnswer(@PathVariable String email,@PathVariable String securityAnswer)
	    {
	    	return dao.validateSecurityAnswer(email, securityAnswer);
	    }
	    @PostMapping("setpassword/{email}/{password}")
	    public ResponseEntity<?> ResetPassword(@PathVariable String email,@PathVariable String password)
	    {
	    	return dao.ResetUserPassword(email, password);
	    }
	    
}
