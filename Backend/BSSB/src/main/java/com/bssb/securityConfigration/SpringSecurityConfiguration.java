package com.bssb.securityConfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	 private ServiceCenterDetailsService serviceCenter;
	@Autowired
	private AdminDetailsService admin;
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(serviceCenter).passwordEncoder(passwordEncoder());
		auth.userDetailsService(admin).passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/helloadmin").hasRole("CENTER")
		.antMatchers("/booking/newbooking").hasAnyRole("CUSTOMER","CENTER","ADMIN")

		// ADD URL HERE
		.antMatchers("/authenticateUser","/center/register", "/customer/register","/authenticatecenter","/authenticateadmin","/booking/newbooking","/plan/add",
				"/plan/getPlans/{regNo}","/center/getAll","/center/getAllNames","/center/getCenterByName/{name}","/center/getCenterByCity/{city}",
				"/slotmanagement/getSlots/{regNo}/{date}","/booking/newbooking","/slotmanagement/getSlot/{regNo}","/booking/getTodaysBooking/{email}/{date}","/center//register","/center/getCities",
				"/plan/uploadImage","/plan/images/{imageName}","/center/register","plan/images/{imageName}","/center/updateServiceCenter","/slotmanagement/addSlots","/booking/getBookingId",
				"/booking/deleteBooking/{bookingId}","booking/bookingHistory/{startdate}/{enddate}/{centerName}","/booking/getTodaysBooking/{email}/{date}","/booking/bookingHistory/{startdate}/{enddate}/{centerName}").permitAll().anyRequest().authenticated()

	

		.and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		and().addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}



}
