package com.alam.tech.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alam.tech.model.Role;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
