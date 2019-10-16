package com.mohit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		Coach thecoach=context.getBean("myCoachDI",CricketCoach.class);
		Coach aplhacoach=context.getBean("myCoachDI",CricketCoach.class);
		
		// to check objects are same
		boolean result = (aplhacoach==thecoach);
		
		System.out.println(result);
		System.out.println(thecoach);
		System.out.println(aplhacoach);
		
		context.close();
		
	}

}
