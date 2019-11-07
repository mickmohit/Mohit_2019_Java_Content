package CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


//https://netjs.blogspot.com/2018/11/completablefuture-in-java-with-examples.html
public class CompletableFutureTest {

	public static void main(String[] args) {    
        CompletableFutureTest CompletableFutureTest = new CompletableFutureTest();    
        try {
            // blocking call
            CompletableFutureTest.getUsers();
        } catch (ExecutionException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void getUsers() throws ExecutionException, InterruptedException{
        CompletableFuture<List<User>> userList = CompletableFuture.supplyAsync(() -> {
            return getListOfUsers();
        }).thenCompose(users-> {            
                List<User> upperCaseList = null;
                try {
                    upperCaseList = users.get().stream().map(
                                user->{
                                    user.setFirstName(user.getFirstName().toUpperCase());
                                    user.setLastName(user.getLastName().toUpperCase());
                                    return user;
                                }).collect(Collectors.toList());
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            return CompletableFuture.completedFuture(upperCaseList);
        });
        
        userList.get().forEach(s->System.out.println(s));
    }
    
    // Dummy method for adding List of Users
    private CompletableFuture<List<User>> getListOfUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Jack", "Reacher", "abc@xyz.com"));    
        users.add(new User("Remington", "Steele", "rs@cbd.com"));
        users.add(new User("Laura", "Holt", "lh@cbd.com"));
        users.add(new User("Jonathan", "Raven", "jr@sn.com"));
        users.add(new User("Tom", "Hanson", "th@jd.com"));
        users.add(new User("Alexander", "Scott", "as@is.com"));
        users.add(new User("Jim", "Phelps", "jp@mi.com"));
        return CompletableFuture.completedFuture(users);
    }
}
