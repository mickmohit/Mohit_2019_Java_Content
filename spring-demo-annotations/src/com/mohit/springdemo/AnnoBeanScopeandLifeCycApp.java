package com.mohit.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoBeanScopeandLifeCycApp {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Coach thecoach=context.getBean("tennisCoach",TennisCoach.class);
			Coach aplhacoach=context.getBean("tennisCoach",TennisCoach.class);
			
			// to check objects are same
			boolean result = (aplhacoach==thecoach);
			
			System.out.println(result);
			System.out.println(thecoach);
			System.out.println(aplhacoach);
			
			context.close();
			
		}

	}
