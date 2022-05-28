package com.mali.multiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* https://www.geeksforgeeks.org/difference-between-countdownlatch-and-cyclicbarrier-in-java/ */
public class CountdownLatchDemo {

  //cyclic barrier breaks when required number of threads reach a breaking point.
  static class Worker extends Thread {
    CountDownLatch latch;

    Worker(CountDownLatch latch, String name) {
      super(name);
      this.latch = latch;
    }

    @Override
    public void run() {
      System.out.println("Thread" + Thread.currentThread().getName());
      latch.countDown();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(4);
    Worker w1 = new Worker(latch, "w1");
    Worker w4 = new Worker(latch, "w4");
    Worker w3 = new Worker(latch, "w3");
    Worker w2 = new Worker(latch, "w2");
    ExecutorService es = Executors.newFixedThreadPool(4);
    es.submit(w4);
    es.submit(w2);
    es.submit(w3);
    es.submit(w1);

    latch.await();

    System.out.println(Thread.currentThread().getName() + " has finished");
    es.shutdown();
  }
}
