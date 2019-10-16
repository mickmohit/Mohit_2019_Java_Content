package com.mohit.springboot.mycool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

	@Value("${sita.name}")
	private String name;
	
	@Value("${sita.location}")
	private String location;
	
	@GetMapping("/hello")
	public String mess()
	{
		return "Hello Brother!"+ name + "&&& " +location;
	}
	
}
