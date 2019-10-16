package com.mohit.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 30 mins for Cricket Practise";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	//setter Injection 
	public void setFortuneService(FortuneService fortuneService) {
		System.out.print("Inside Setter Injection method");
		this.fortuneService = fortuneService;
	}

	// add an init method
	public void doMyStartupStuff()
	{
		System.out.println("CricketCoach: do my init start up stuff");
	}
	
	// add an destroy method
	public void doMyCleanStuff()
	{
		System.out.println("CricketCoach: do my init Clean up stuff");	
	}
	
	// constructor DI
	// define constructor for dependency injection
		public CricketCoach(FortuneService fortuneService)
		{
			this.fortuneService=fortuneService;
		}
}
