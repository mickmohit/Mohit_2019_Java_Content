package com.mohit.AOPdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.mohit.AOPdemo.Account;

@Component
public class AccountDao {

	private String accountName;
	private String serviceCode;
	
	public void addAccount(Account theaccount)
	{
		System.out.println(getClass()+"Doing my Add Account Stuff");
	}
	
	public void addAccount(Account theaccount, boolean vipflag)
	{
		System.out.println(getClass()+"Doing my Add Account Stuff with VIP flag");
	}
	
	
	public boolean doWork()
	{
		System.out.println(getClass()+":do work");
		return false;
	}

	//add new method for addAccounts
	public List<Account> listAccounts(boolean check)
	{
		if(check==true)
		{
			throw new RuntimeException("No Account found for you from AccountDao");
		}
		
		List<Account> listAccounts= new ArrayList<>();
		Account acc1= new Account("Mohit","1");
		Account acc2= new Account("Ambrish","2");
		Account acc3= new Account("Mukesh","3");
		listAccounts.add(acc1);
		listAccounts.add(acc2);
		listAccounts.add(acc3);
		return listAccounts;
	}
	
	
	public String getAccountName() {
		System.out.println("Inside account Name Get Method");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println("Inside account Name Set Method");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println("Inside Service Get Method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("Inside Service Set Method");
		this.serviceCode = serviceCode;
	}

	
	
	
	
}
