package Chapter2;

public class JavaThreadTest implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Starting Thread Name"+ Thread.currentThread().getName());
		
		for(int i=0;i<10;i++)
		{
			System.out.println("I Love Java");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	System.out.println("Thread Completed"+ Thread.currentThread().getName());	
	}

}
