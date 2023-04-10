// 7.Write program to implement Future and Callable example.

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallableDemo {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 1;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("Doing some work");

        int res=0;
        try {
            res = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("The result is: " + res);

    }
}
