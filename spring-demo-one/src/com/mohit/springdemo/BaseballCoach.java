package com.mohit.springdemo;

public class BaseballCoach implements Coach {
	
	//define private field for dependency
	private FortuneService fortuneService;
	
	// define constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService)
	{
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 mins in Batting Practise";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
