package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	
	public static void main(String[] args){
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println(coreCount);
		ExecutorService service= Executors.newFixedThreadPool(coreCount);
		
		for(int i=0;i<5;i++)
		{
			service.execute(new CpuIntensive());
		}
		
		service.shutdown();
	}

}

class CpuIntensive implements Runnable
{

	@Override
	public void run() {
		int i=1;
		System.out.println("Hello-"+i);
		
	}

}