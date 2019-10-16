package com.mohit.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springrest.entity.Customer;
import com.mohit.springrest.exception.StudentNotFoundException;
import com.mohit.springrest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> listCustomer()
	{
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable("customerID") int customerID)
	{
		
		Customer customer=		customerService.getCustomer(customerID);
		
		if(customer==null)
		{
			throw new StudentNotFoundException("No customer ID found---"+customerID);
		}
		
		return customer;
		
	}
	
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		// id set 0 as hibernate will set id in its own
		customer.setId(0);
		customerService.saveCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		
		customerService.saveCustomer(customer);
		
		return customer;
		
	}
	
	@DeleteMapping("/customers/{customerID}")
	public String deleteCustomer(@PathVariable("customerID") int customerID)
	{
		
		Customer customer=	customerService.getCustomer(customerID);
		
		if(customer==null)
		{
			throw new StudentNotFoundException("No customer ID found---"+customerID);
		}
		
		customerService.deleteCustomer(customerID);
		
		return "Deleted Customer with ID"+customerID;
		
	}
	
}
