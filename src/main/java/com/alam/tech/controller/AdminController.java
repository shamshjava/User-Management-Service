package com.alam.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alam.tech.model.User;
import com.alam.tech.repo.UserRepository;

@RestController
@RequestMapping("/secure/rest")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUser(@RequestBody User user) {
		String pwd = user.getPassword();
		//String ePwd = bCryptPasswordEncoder.encode(pwd);
		user.setPassword(pwd);
		userRepository.save(user);
		return "User Created succesfully.";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/userlist")
	public List<User> userList() {
		return userRepository.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/deleteuser")
	public String userDelete(@RequestParam String userName) {
		userRepository.deleteByuserName(userName);
		return "User deleted successfully.";
	}
}
