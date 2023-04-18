// 5.Write program to implement all types of Executors.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private String name;

    public Task (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing " + name);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " completed " +  name );
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Task("SingleThreadExecutor 1"));
        singleThreadExecutor.execute(new Task("SingleThreadExecutor 2"));
        singleThreadExecutor.shutdown();


        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        // fixedThreadPool.execute(new Task("FixedThreadPool 1"));
        // fixedThreadPool.execute(new Task("FixedThreadPool 2"));
        // fixedThreadPool.execute(new Task("FixedThreadPool 3"));
        // fixedThreadPool.shutdown();


        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // cachedThreadPool.execute(new Task("CachedThreadPool 1"));
        // cachedThreadPool.execute(new Task("CachedThreadPool 2"));
        // cachedThreadPool.execute(new Task("CachedThreadPool 3"));
        // cachedThreadPool.shutdown();


        // ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        // ScheduledFuture<?> scheduledFuture = scheduledThreadPool.schedule(new Task("ScheduledThreadPool 1"), 5, TimeUnit.SECONDS);
        // scheduledThreadPool.schedule(new Task("ScheduledThreadPool 2"), 3, TimeUnit.SECONDS);

        // scheduledThreadPool.scheduleAtFixedRate(new Task("FixedScheduledThreadPool 3"), 1, 1, TimeUnit.SECONDS);
        // scheduledThreadPool.scheduleAtFixedRate(new Task("FixedScheduledThreadPool 4"), 2, 2, TimeUnit.SECONDS);

        // try {
        //     scheduledFuture.get();
        // }
        // catch (Exception e) {
        //     e.printStackTrace();
        // }
        // scheduledThreadPool.shutdown();
    }
}