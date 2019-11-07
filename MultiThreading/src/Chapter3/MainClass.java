package Chapter3;


  
class MainClass 
{ 
    public static void main (String[] args) 
    { 
  
        // creating two threads 
        ThreadJoining1 t1 = new ThreadJoining1(); 
        ThreadJoining1 t2 = new ThreadJoining1(); 
        ThreadJoining1 t3 = new ThreadJoining1(); 
  
        // thread t1 starts 
        t1.start(); 
  
        // starts second thread after when 
        // first thread t1 has died. 
        try
        { 
        	while(t1.isAlive()) {System.out.print("Thread is Alive");}
            System.out.println("Current Thread: "
                  + Thread.currentThread().getName()); 
            t1.join(); 
            
        } 
  
        catch(Exception ex) 
        { 
            System.out.println("Exception has " + 
                                "been caught" + ex); 
        } 
  
       
        // t2 starts 
        t2.start(); 
  
        // starts t3 after when thread t2 has died. 
        try
        { 
            System.out.println("Current Thread: "
                 + Thread.currentThread().getName()); 
            t2.join(); 
        } 
  
        catch(Exception ex) 
        { 
            System.out.println("Exception has been" + 
                                    " caught" + ex); 
        } 
  
        t3.start(); 
    } 
} 