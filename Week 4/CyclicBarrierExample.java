import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier barrier = new CyclicBarrier(3, () -> {
      System.out.println("Barrier reached");
    });

    Thread t1 = new Thread(() -> {
      System.out.println("Task 1 is running");
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      System.out.println("Task 2 is running");
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    });

    Thread t3 = new Thread(() -> {
      System.out.println("Task 3 is running");
      try {
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
      }
    });

    t1.start();
    t2.start();
    t3.start();

    t1.join();
    t2.join();
    t3.join();
  }
}
