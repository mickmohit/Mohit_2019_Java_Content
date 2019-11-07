package com.mohit.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitOneLambda {

	public static void main(String[] args)
	{
		List<Person> person = Arrays.asList(
				new Person("Mohit", "Darmwal", 1),
				new Person("Rohit", "Oarmwal", 1),
				new Person("Tohit", "Darmwal", 1)
				);
				
		
		//Sort by last name
		Collections.sort(person, ( p1,  p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		printAll(person);
		
		printConditionally(person,  p -> p.getLastName().startsWith("D"));
	}
	
	public static void printAll(List<Person> person)
	{
		for(Person p: person)
		{
			System.out.println(p);
		}
	}
	
	public static void printConditionally(List<Person> person, Condition condition)
	{
		for(Person p: person)
		{
			if(condition.test(p))
				System.out.println(p);
		}
	}

	interface Condition
	{
		boolean test(Person p);
	}
}
