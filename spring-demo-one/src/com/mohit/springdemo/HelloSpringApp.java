package com.mohit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		//Using IOC
		Coach theCoach= context.getBean("myCoach1", Coach.class); 
		
		// using DI with constructor injection
		Coach theCoachDI= context.getBean("myCoachDI", Coach.class); 
		
		// using DI with setter injection
		Coach theCricCoachDI= context.getBean("myCricCoachDI", CricketCoach.class); 
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoachDI.getDailyFortune());
		System.out.println(theCricCoachDI.getDailyFortune());
		
		//using cast to implementation class here as in above getBean method we have mentioned implementation
		//class instead of interface as to get CricketCoach methods
		System.out.println(((CricketCoach) theCricCoachDI).getEmailAddress());
		System.out.println(((CricketCoach) theCricCoachDI).getTeam());
		
		context.close();
	}

}
