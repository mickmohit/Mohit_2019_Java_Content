package Chapter1;

public class Chapter1 {
	
	public static void main(String[] args)
	{
		Thread th= Thread.currentThread();
		
		System.out.println(th.getName());
		
		th.setName("Mohit test Thread");

		System.out.println(th.getName());
		
	}

}
