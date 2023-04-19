import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(3);

    Thread t1 = new Thread(() -> {
      System.out.println("Thread 1 is running");
      latch.countDown();
    });

    Thread t2 = new Thread(() -> {
      System.out.println("Thread 2 is running");
      latch.countDown();
    });

    Thread t3 = new Thread(() -> {
      System.out.println("Thread 3 is running");
      latch.countDown();
    });

    t1.start();
    t2.start();
    t3.start();

    latch.await();
    System.out.println("All Threads completed");
  }
}
