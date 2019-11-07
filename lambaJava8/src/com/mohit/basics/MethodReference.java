package com.mohit.basics;

public class MethodReference {

	public static void main(String [] args)
	{
		Thread th= new Thread(() -> printMessage());
		Thread th1= new Thread(MethodReference::printMessage); //Method Reference
		th.start();
		th1.start();
	}
	
	public static void printMessage()
	{
		System.out.println("Hello");
	}
}
