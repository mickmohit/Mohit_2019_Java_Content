package com.mohit.Part1;

public class Main {
	
	public static void main(String[] args)
	{
		/*Thread th= new Thread(()->
		System.out.println("Hello--"+Thread.currentThread().getName()));
		
		th.setName("New Worker Thread");
		th.start();*/
		
		Thread th= new NewThread();
		th.start();
			
	}

}

class NewThread extends Thread
{
public void run()
{
	System.out.println("Hello--"+Thread.currentThread().getName());
}
}