package org.example.thread;

import java.util.concurrent.Executor;

public class ExecutorTest {
    public static void main(String[] args) {
        Executor executor = command -> new Thread(command).start();
        executor.execute(
                () -> System.out.println("Task executed")
        );
        Runnable run1 = () -> {
            System.out.println("Hi");
        };
        Thread t = new Thread(run1);
        t.start();
    }


}

