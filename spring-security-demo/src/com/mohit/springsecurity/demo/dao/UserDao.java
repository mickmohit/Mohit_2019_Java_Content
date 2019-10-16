package com.mohit.springsecurity.demo.dao;

import com.mohit.springsecurity.demo.entity.User;

public interface UserDao {
User findByUserName(String userName);
    
    void save(User user);

	}
