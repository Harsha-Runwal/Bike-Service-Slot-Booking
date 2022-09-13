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
import com.bssb.entity.ServiceCenter;
import com.bssb.repository.CustomerRepository;
import com.bssb.repository.ServiceCenterRepository;
import com.bssb.securityModel.UserDTO;


@Service
public class ServiceCenterDetailsService implements UserDetailsService {

	
	@Autowired
	private ServiceCenterRepository serviceRepo;

	/*@Autowired
	public  ServiceCenterDetailsService(ServiceCenterRepository serviceRepo )
	{
		this.serviceRepo=serviceRepo;
	}*/
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
		 
			System.out.println("checking" +" email cheking"+email);
			//serviceRepo.save(new Customer("kundan","bhagat","sdad","sda","SADds","sadasd"));
		  
		ServiceCenter user = serviceRepo.findByEmail(email);
		  
		System.out.println("afte finding by email in service center "+user);
		if (user != null) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 String encodedPassword = passwordEncoder.encode(user.getPassword());
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getEmail(), encodedPassword, roles);
		}
		throw new UsernameNotFoundException("User not found with the name " );	}
	
	
}
