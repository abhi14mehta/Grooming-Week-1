// 2.How will you create a task & execute it.

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Task extends TimerTask {
    public void run() {
        System.out.println("Task is running");
    }
}
public class CreateTaskAndExecute {
    public static void main(String[] args) {
        // creating timer having method schedule(task,time)
        Timer timer = new Timer();
        // creating timer task that needs to execute
        TimerTask task = new Task(); 
        // scheduling the task by passing current date so that it executes instantly
        timer.schedule(task, new Date()); 
    }
    public void run() {
        System.out.println("Performing the given task");
    }
}
