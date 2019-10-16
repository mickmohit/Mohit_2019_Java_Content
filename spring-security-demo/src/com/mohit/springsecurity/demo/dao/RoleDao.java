package com.mohit.springsecurity.demo.dao;

import com.mohit.springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
