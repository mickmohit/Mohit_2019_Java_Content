package com.mohit.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise backend volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public TennisCoach() {
		System.out.println("Default Constructor");
	}
	
	//constructor DI
	/*@Autowired
	public TennisCoach(FortuneService fortuneService)
	{
		this.fortuneService=fortuneService;
	}*/

	

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
}
