// 2.How will you create a task & execute it.

import java.util.concurrent.Callable;

public class CreateTaskAndExecute implements Callable<Integer> {
    public static void main(String[] args) throws Exception {
        CreateTaskAndExecute createAndExecuteTask = new CreateTaskAndExecute();
        int value = createAndExecuteTask.call();
        System.out.println(value);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task Running");
        return 1;
    }

}