package com.alam.tech.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alam.tech.model.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserName(String username);

	void deleteByuserName(String userName);

	@Query("SELECT u from User u where u.userName =:name and u.password =:pwd")
	User findByuserNameAndpassword(String name, String pwd);

}