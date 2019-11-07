package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	
public static void main(String[] args){
		
		
		ScheduledExecutorService service= Executors.newScheduledThreadPool(10);
		
		service.schedule(new CpuIntensive(), 10, TimeUnit.SECONDS);
		
		service.scheduleAtFixedRate(new CpuIntensive(), 15, 10, TimeUnit.SECONDS);
		
		service.scheduleWithFixedDelay(new CpuIntensive(), 15, 10, TimeUnit.SECONDS);
	}


}
