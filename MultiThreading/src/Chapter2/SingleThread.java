package Chapter2;

public class SingleThread {

	public static void main(String[] args) throws Exception
	{
		
		createJavaThread();	
		createJavaThreadFx();
		createJavaThreadAdvance();
	}

	private static void createJavaThreadAdvance() {
		
JavaThreadAdvance thTest= new JavaThreadAdvance();
		
		Thread th= new Thread(thTest);
		th.setName("JAVA_ADVANCE_THREAD");
		
		th.start();
	}

	private static void createJavaThreadFx() {
	
JavaThreadFx thTest= new JavaThreadFx();
		
		Thread th= new Thread(thTest);
		th.setName("JAVA_FX_THREAD");
		
		th.start();
		
	}

	private static void createJavaThread() {
		
		JavaThreadTest thTest= new JavaThreadTest();
		
		Thread th= new Thread(thTest);
		th.setName("JAVA_THREAD");
		
		th.start();
		
	}
	
}
