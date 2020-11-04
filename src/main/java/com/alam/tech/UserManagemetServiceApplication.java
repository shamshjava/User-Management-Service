package com.alam.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.alam.tech.repo.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class UserManagemetServiceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagemetServiceApplication.class, args);
	}
	
	

}
