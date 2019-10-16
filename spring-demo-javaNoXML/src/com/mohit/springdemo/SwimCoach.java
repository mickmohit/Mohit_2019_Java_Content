package com.mohit.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise 100 meter swim for warm up!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public SwimCoach() {
		System.out.println("Default Constructor");
	}
	
	//constructor DI
	
	public SwimCoach(FortuneService fortuneService)
	{
		this.fortuneService=fortuneService;
	}

	

	/*//setter DI
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	
	//define my init method through Annotation
	@PostConstruct
	public void doMyStartUp()
	{
		System.out.println("inside of doMyStartUp");
	}
	
	//define my destroy method through Annotation
		@PreDestroy
		public void doMyCleanUp()
		{
			System.out.println("inside of doMyCleanUp");
		}

		public String getEmail() {
			return email;
		}

		public String getTeam() {
			return team;
		}
		
		
}
