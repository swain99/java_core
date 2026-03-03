package org.example.thread;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerThread {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
class ProducerConsumer{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 5;
    public void producer() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (this) {
                if (capacity == list.size()) {
                    System.out.println("Bucket is full, no space available to produce message");
                    notify();
                    wait();
                }
                list.add(value);
                System.out.println("Producer produce data: "+value);
                value++;
                notify();
                Thread.sleep(1000);

            }
        }

    }
    public void consumer() throws InterruptedException{
        while(true) {
            synchronized (this) {
                if (list.isEmpty()) {
                    System.out.println("Bucket is empty , no data available to consume");
                    notify();
                    wait();
                }
                System.out.println("Consumer consume data: " + list.removeFirst());
                notify();
                Thread.sleep(1000);
            }
        }

    }
}