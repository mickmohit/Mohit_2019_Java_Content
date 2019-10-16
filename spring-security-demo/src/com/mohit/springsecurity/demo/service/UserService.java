package com.mohit.springsecurity.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mohit.springsecurity.demo.entity.User;
import com.mohit.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}