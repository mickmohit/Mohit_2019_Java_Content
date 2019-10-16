package com.mohit.springdemo.service;

import java.util.List;

import com.mohit.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
}
