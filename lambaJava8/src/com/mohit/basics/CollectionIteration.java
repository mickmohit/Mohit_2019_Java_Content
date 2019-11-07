package com.mohit.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mohit.exercise.Person;

public class CollectionIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> person = Arrays.asList(
				new Person("Mohit", "Darmwal", 1),
				new Person("Rohit", "Oarmwal", 1),
				new Person("Tohit", "Darmwal", 1)
				);
		
		person.forEach(p -> System.out.println(p));
		System.out.println("------------------");
		
		person.forEach(System.out::println);
		System.out.println("------------------");
		
		person.stream()
		.filter(p ->p.getLastName().startsWith("O"))
		.forEach(p -> System.out.println(p.getFirstName()));
		System.out.println("------------------");
		
		/*person.stream()
		.filter(p ->p.getLastName().startsWith("O"))
		.map(mapper)
		.forEach(p -> System.out.println(p.getFirstName()));*/
		
		List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        
        List<Integer> evenNumbersList = 
        		list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);
        
        
        
        List<String> myList =
        	    Arrays.asList("a1", "a2", "b1", "c2", "c1");

        	myList
        	    .stream()
        	    .filter(s -> s.startsWith("c"))
        	    .map(p -> p.toUpperCase())
        	    .sorted().collect(Collectors.toList())
        	    .forEach(p -> System.out.println(p));
	}

}
