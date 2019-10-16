package com.mohit.AOPdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount()
	{
		System.out.println(getClass()+"Doing my Add Membership Account Stuff");
	}
	
	public void doSLeep()
	{
		System.out.println(getClass()+"Going for SLeep");
	}
	
}
