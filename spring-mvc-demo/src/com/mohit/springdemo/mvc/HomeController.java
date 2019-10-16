package com.mohit.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String showProcess()
	{
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String showProcessVersionTwo(HttpServletRequest request, Model model)
	{
		
		String s= request.getParameter("studentName");
		s=s.toUpperCase();
		model.addAttribute("message",s);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String showProcessVersionThree(@RequestParam("studentName") String theName, Model model)
	{
		
		
		theName=theName.toUpperCase();
		model.addAttribute("message",theName);
		return "helloworld";
	}
}
