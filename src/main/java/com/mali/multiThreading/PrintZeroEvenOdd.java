package com.mali.multiThreading;

import java.util.concurrent.Semaphore;

public class PrintZeroEvenOdd {

  private int n;

  public PrintZeroEvenOdd(int n) {
    this.n = n;
  }

  Semaphore zero = new Semaphore(1);

  // imp : semaphore(0) -> initially it will be locked unless someone releases it.
  Semaphore odd = new Semaphore(0);
  Semaphore even = new Semaphore(0);

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero() throws InterruptedException {
    boolean bol = false;

    for (int i = 0; i < n; i++) {
      zero.acquire();
      System.out.println(0);
      if (bol) {
        even.release();
      } else {
        odd.release();
      }
      bol = !bol;
    }
  }

  public void even() throws InterruptedException {
    for (int i = 2; i <= n; i = i + 2) {
      even.acquire();
      System.out.println(i);
      zero.release();
    }
  }

  public void odd() throws InterruptedException {
    for (int i = 1; i <= n; i = i + 2) {
      odd.acquire();
      System.out.println(i);
      zero.release();
    }
  }
}
