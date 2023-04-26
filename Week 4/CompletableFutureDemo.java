// 1. Write a program to run a simple asynchronous stage using CompletableFuture.

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            future.complete("Hello, world!");
        }).start();

        future.thenAccept(System.out::println);

        System.out.println("Program is still running...");
    }
}