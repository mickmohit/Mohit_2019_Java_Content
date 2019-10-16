package com.mohit.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.mohit.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define bean for Fortune Service
	@Bean
	public FortuneService randomFortuneService()
	{
	return new RandomFortuneService();	
	}
	
	// define bean for swim coach and inject DI, passing randomFortuneService() 
	// because you have declared constructor DI in swimcoach 
	@Bean
	public Coach swimCoach()
	{
		return new SwimCoach(randomFortuneService());
	}
	
}
