package Chapter7;

public class NonDeamonThreadProblem {

    public static void main(String[] args) {
        new Thread (() ->  {
        	while(true)
        	{
        		try {
        			Thread.sleep(3000);
        		}
        		catch(Exception e) {}
        	}
        }).start();
        
        System.out.println("Expecting program shutdown now");
    }
}
