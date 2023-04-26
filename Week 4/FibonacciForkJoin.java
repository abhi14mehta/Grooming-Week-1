import java.util.concurrent.*;

public class FibonacciForkJoin extends RecursiveAction {

    private static final int THRESHOLD = 10; // the threshold for splitting the problem
    private final int n;
    private long result;

    public FibonacciForkJoin(int n) {
        this.n = n;
    }

    public long getResult() {
        return result;
    }

    @Override
    protected void compute() {
        if (n <= THRESHOLD) {
           
            result = fibonacci(n);
        } else {
            
            FibonacciForkJoin leftTask = new FibonacciForkJoin(n - 1);
            FibonacciForkJoin rightTask = new FibonacciForkJoin(n - 2);
            leftTask.fork();
            rightTask.compute();
            leftTask.join();
            result = leftTask.getResult() + rightTask.getResult();
        }
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            long[] fib = new long[n + 1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[n];
        }
    }

    public static void main(String[] args) {
        int n = 30;
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciForkJoin task = new FibonacciForkJoin(n);
        pool.invoke(task);
        long result = task.getResult();
        System.out.println("Fibonacci(" + n + ") = " + result);
    }
}


