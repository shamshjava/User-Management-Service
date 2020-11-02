package com.alam.tech.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Role {
	
	@Id
	private int roleId;
	private String role;

}
