package com.mohit.exercise;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args)
	{
		int someNumbers[]= {1,2,3,4};
		int key=0;
		
		process(someNumbers,key);
		System.out.println("--------------------------");
		
		processLambda(someNumbers, key, (k,v) -> System.out.println(k+v));
		System.out.println("--------------------------");
		
		processLambda(someNumbers, key, (k,v) -> {
			try{
				System.out.println(k/v);
			}
			catch(Exception e)
			{System.out.println("Error Dude");}
			});
		
		System.out.println("--------Wrapper Lambda Exception way------------------");
		processLambda(someNumbers, key, wrapperLambda((k,v) -> System.out.println(k/v)));
	
	}

	private static void process(int[] someNumbers, int key) {
		// TODO Auto-generated method stub
		for(int i: someNumbers)
			System.out.println(i+key);
	}
	
	private static void processLambda(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		// TODO Auto-generated method stub
		for(int i: someNumbers)
			consumer.accept(i, key);
	}
	
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer)
	{
		return (v,k) -> {
			try {
			consumer.accept(v, k);
			}catch(Exception e)
			{
				System.out.println("Error caught in Wrapper Lambda");
			}
		};
	}
	
}
