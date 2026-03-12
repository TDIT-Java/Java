package org.Java.ExecutorService;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "Result of Task 1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(500);
            return "Result of Task 2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(700);
            return "Result of Task 3";
        };

        try {
            Future<String> result1 = executor.submit(task1);
            Future<String> result2 = executor.submit(task2);
            Future<String> result3 = executor.submit(task3);

            System.out.println(result1.get());
            System.out.println(result2.get());
            System.out.println(result3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
