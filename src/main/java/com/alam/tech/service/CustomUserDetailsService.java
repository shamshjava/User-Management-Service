package com.alam.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alam.tech.model.User;
import com.alam.tech.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByuserName(username);
		CustomUserDetails userDetails = null;
		if(user != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
			
		}else {
			throw new UsernameNotFoundException("User not exist with name:" + username);
		}
		return userDetails;
	}

}
