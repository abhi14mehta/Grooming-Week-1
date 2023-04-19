import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
  private ReentrantLock lock = new ReentrantLock();
  private int count = 0;

  public void increment() {
    lock.lock();
    try {
      count++;
      System.out.println("Count incremented to " + count + " by " + Thread.currentThread().getName());
    } finally {
      lock.unlock();
    }
  }

  public void decrement() {
    lock.lock();
    try {
      count--;
      System.out.println("Count decremented to " + count + " by " + Thread.currentThread().getName());
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReentrantLockDemo example = new ReentrantLockDemo();

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        example.increment();
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        example.decrement();
      }
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("Final count value is " + example.count);
  }
}
