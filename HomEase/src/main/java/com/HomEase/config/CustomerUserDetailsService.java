package com.HomEase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.HomEase.entity.User;
import com.HomEase.repo.UserRepository;


public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
User user=userRepository.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException(username);
		
		return new CustomerUserDetails(user);	}

}
