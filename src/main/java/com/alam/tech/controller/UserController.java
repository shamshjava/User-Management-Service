package com.alam.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/*
	 * @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	
	
	@PutMapping("/usersignin")
	public String signIn(@RequestParam String name, @RequestParam String pwd) throws Exception {
		//String ePwd = bCryptPasswordEncoder.encode(pwd);
		User user = userRepository.findByuserNameAndpassword(name,pwd);
		if(user == null) {
			throw new Exception("Invalid user and password");
		}
		user.setActive("yes");
		userRepository.save(user);
		return "Signed in successfully.";
	}
	
	
	@GetMapping("/userdetail")
	public User userDetail(@RequestParam String name) throws Exception {
		User user = userRepository.findByuserName(name);
		if(user == null) {
			throw new Exception("User " + name + "not exist");
		}
		return user;
	}
	
	@PutMapping("/userlogout")
	public String signIn(@RequestParam String name) throws Exception {
		User user = userRepository.findByuserName(name);
		if(user == null) {
			throw new Exception("User " + name + "not logged in.");
		}
		user.setActive("");
		userRepository.save(user);
		return "Logged out in successfully.";
	}
	
	
}
