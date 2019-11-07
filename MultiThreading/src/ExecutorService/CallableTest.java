package ExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

public static void main(String[] args) throws Exception{
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println(coreCount);
		ExecutorService service= Executors.newFixedThreadPool(coreCount);
		
		List<Future> allFutures= new ArrayList<>();
		
		for(int i=0;i<10;i++) {		
		Future<Integer> future =service.submit(new TaskTest());
		allFutures.add(future);
		}
		
		for(int i=0;i<10;i++) {	
			Future<Integer> future =allFutures.get(i);
		int result= future.get();//blocking
		System.out.println("result"+result);
		}
		
		service.shutdown();
	}
}

class TaskTest implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(200);
		return new Random().nextInt();
	}

}
