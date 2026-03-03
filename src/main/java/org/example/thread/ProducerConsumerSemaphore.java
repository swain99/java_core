package org.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerSemaphore {
    static int BUCKET_SIZE = 5;
    static int[] BUCKET = new int[BUCKET_SIZE];
    static final Lock lock = new ReentrantLock();
    static final Condition isFull = lock.newCondition();
    static final Condition isEmpty = lock.newCondition();
    static int in = 0, out = 0, count = 0;

    public static void producer() {
        while (true) {
            lock.lock();
            try {
                while (count == BUCKET_SIZE) {
                    System.out.println("Bucket is full !");
                    isFull.await();
                }
                int item = (int) (Math.random() * 100);
                BUCKET[in] = item;
                System.out.println("Producer produce data : Bucket [" + in + "] - " + item);
                in = (in + 1) % BUCKET_SIZE;
                count++;
                isEmpty.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void consumer() {
        while (true) {
            lock.lock();
            try {
                while (count == 0) {
                    System.out.println("Bucket is empty !");
                    isEmpty.await();
                }
                int item = BUCKET[out];
                System.out.println("Consumer consume data : Bucket [" + out + "] - " + item);
                out = (out + 1) % BUCKET_SIZE;
                count--;
                isFull.signal();

            } catch (InterruptedException e) {
               e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(ProducerConsumerSemaphore::producer);
        Thread consumerThread = new Thread(ProducerConsumerSemaphore::consumer);
        producerThread.start();
        consumerThread.start();

    }
}
