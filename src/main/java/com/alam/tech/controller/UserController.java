package com.alam.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alam.tech.model.User;
import com.alam.tech.repo.UserRepository;

@RestController
@RequestMapping("/rest/auth")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@GetMapping("/usersignin")
	public String signIn(@RequestParam String name, @RequestParam String pwd) {
		//String ePwd = bCryptPasswordEncoder.encode(pwd);
		User user = userRepository.findByuserNameAndpassword(name,pwd);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid user and password");
		}
		return "Signed in successfully.";
	}
	
	
	@GetMapping("/userdetail")
	public User userDetail(@RequestParam String name) {
		User user = userRepository.findByuserName(name);
		return user;
	}
	
	
}
