package com.mali.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// print odd even numbers using semaphore
public class Semaphore_Print {
  Semaphore even = new Semaphore(0);
  Semaphore odd = new Semaphore(1);

  public void printEven(int num) throws InterruptedException {
    even.acquire();
    System.out.println(num);
    odd.release();
  }

  public void printOdd(int num) throws InterruptedException {
    odd.acquire();
    System.out.println(num);
    even.release();
  }

  static class EvenProducer implements Runnable {
    Semaphore_Print sp;

    EvenProducer(Semaphore_Print sp) {
      this.sp = sp;
    }

    @Override
    public void run() {
      for (int i = 2; i < 10; i = i + 2) {
        try {
          sp.printEven(i);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class OddProducer implements Runnable {
    Semaphore_Print sp;

    OddProducer(Semaphore_Print sp) {
      this.sp = sp;
    }

    @Override
    public void run() {
      for (int i = 1; i < 10; i = i + 2) {
        try {
          sp.printOdd(i);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    Semaphore_Print sp = new Semaphore_Print();
    ExecutorService es = Executors.newFixedThreadPool(2);
    OddProducer op = new OddProducer(sp);
    EvenProducer ep = new EvenProducer(sp);
    es.execute(op);
    es.execute(ep);
    es.shutdown();
  }
}
