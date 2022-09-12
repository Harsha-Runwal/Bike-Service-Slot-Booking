package com.bssb.securityConfigration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bssb.entity.Customer;
import com.bssb.repository.CustomerRepository;


import com.bssb.securityModel.UserDTO;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	
	private CustomerRepository customerRepo;

	@Autowired
	public  CustomUserDetailsService(CustomerRepository customerRepo )
	{
		this.customerRepo=customerRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
		 
			System.out.println("checking insde customer table");
		//	customerRepo.save(new Customer("kundan","bhagat","sdad","sda","SADds","sadasd"));
		List<Customer> list= customerRepo.findAll();
			 System.out.println("no of element in customer database"+list.size());
			   
			//Customer cust= customerRepo.findById(1).get();
			//System.out.println("afte finding "+cust);
		Customer user = customerRepo.findByEmail(email);
		  
		System.out.println("afte finding by email"+user);
		if (user != null) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 String encodedPassword = passwordEncoder.encode(user.getPassword());
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getEmail(), encodedPassword, roles);
		}
		throw new UsernameNotFoundException("User not found with the name " );	}
	
	
}
