package com.mohit;

public class Greeter {

	public void greet(Greeting greeting)
	{
		System.out.println("Inside Greeter method: Hello Greeter");
		greeting.perform();
	}
	
public static void main(String[] args)
{
	Greeter greeter= new Greeter();
	
	//Normal Way of calling method through instance
	HelloGreeting helloGreeting = new HelloGreeting();
	greeter.greet(helloGreeting);
	
	//passing interface implementation behaviour for calling method of implementation class
		Greeting helloGreeting_new = new HelloGreeting();
		helloGreeting_new.perform();
	
	//Lambda way of calling
		Greeting mytestLambda= () -> System.out.println("Lambda Greeting Print");
		mytestLambda.perform();
		
	MyLambda mytestLambda_basic= () -> System.out.println("Lambda Print");
	
	
	MyLambdaAdd mytestLambdaAdd=(int a , int b) -> (a+b);
	
	System.out.println(mytestLambdaAdd.foo(4, 5));
}
	
}


interface MyLambda
{
void foo();
}

interface MyLambdaAdd
{
int foo(int a, int b);
}