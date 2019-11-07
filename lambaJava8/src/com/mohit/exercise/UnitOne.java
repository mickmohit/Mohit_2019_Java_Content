package com.mohit.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitOne {

	public static void main(String[] args)
	{
		List<Person> person = Arrays.asList(
				new Person("Mohit", "Darmwal", 1),
				new Person("Rohit", "Oarmwal", 1),
				new Person("Tohit", "Darmwal", 1)
				);
				
		
		//Sort by last name
		Collections.sort(person, new Comparator<Person>() {

			@Override
			public int compare(Person arg0, Person arg1) {
				// TODO Auto-generated method stub
				return arg0.getLastName().compareTo(arg1.getLastName());
			}
			
		});
		
		printAll(person);
		printConditionally(person, new Condition() {

			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.getLastName().startsWith("D");
			}
			
		});
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
