package com.mohit;

public class RunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread mythread= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Printing Runnable");
			}
		}); 
		
		mythread.run();
		
		Thread myLambdaThread = new Thread(() ->System.out.println("Printing Runnable Thread"));
		myLambdaThread.run();
	}

	
}
