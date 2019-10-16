package com.mohit.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/employees")
	public String showTime()
	{
		return "home";
	}
	@GetMapping("/")
    public String showLanding() {
        return "landing";
    }
	
	@GetMapping("/leaders")
    public String showleaders() {
        return "leaders";
    }
	
	@GetMapping("/admin")
    public String showadmin() {
        return "admin";
    }
	
}
