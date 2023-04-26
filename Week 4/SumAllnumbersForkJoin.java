// 3.Write a fork and join program to sum all the numbers from a range.- RecursiveTask

import java.util.concurrent.*;

public class SumAllnumbersForkJoin extends RecursiveTask<Long> {
    
    private static final long THRESHOLD = 1000; // the threshold for splitting the range
    private final long start;
    private final long end;

    public SumAllnumbersForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            
            long mid = (start + end) / 2;
            SumAllnumbersForkJoin leftTask = new SumAllnumbersForkJoin(start, mid);
            SumAllnumbersForkJoin rightTask = new SumAllnumbersForkJoin(mid + 1, end);
            leftTask.fork();
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        long start = 1;
        long end = 10000;
        ForkJoinPool pool = new ForkJoinPool();
        SumAllnumbersForkJoin task = new SumAllnumbersForkJoin(start, end);
        long result = pool.invoke(task);
        System.out.println("Sum of " + start + " to " + end + " is " + result);
    }
}