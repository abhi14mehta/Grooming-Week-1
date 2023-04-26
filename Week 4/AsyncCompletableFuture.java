// 2. Run a task asynchronously and return the result 

import java.util.concurrent.CompletableFuture;

public class AsyncCompletableFuture {
    public static void main(String[] args) throws InterruptedException {
        // using lambda to define get method anonymously

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            return "Heyy from CompletableFuture object !!";
        });
        Thread.sleep(1000);
        System.out.println("Waiting for computation to complete...");
        
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });
        
        System.out.println("Done.");
    }
}
