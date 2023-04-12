// 2. How will you create a task & execute it.

import java.util.concurrent.*;

class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task using runnable");
    }
}

class CallableTask implements Callable<String> {
    @Override
    public String call() {
        return "Task using callable";
    }
}

public class CreateTaskAndExecute {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunnableTask());

        Future<String> futureTask = executorService.submit(new CallableTask());

        try{
            System.out.println(futureTask.get());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}