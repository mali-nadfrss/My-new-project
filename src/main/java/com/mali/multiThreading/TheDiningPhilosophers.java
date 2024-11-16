package com.mali.multiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* https://leetcode.com/problems/the-dining-philosophers/description/ */
public class TheDiningPhilosophers {

  Semaphore[] forks;
  ReentrantLock eaters;

  public TheDiningPhilosophers() {
    for (int i = 0; i < 5; i++) {
      forks[i] = new Semaphore(1);
    }
    eaters = new ReentrantLock();
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(
      int philosopher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putLeftFork,
      Runnable putRightFork)
      throws InterruptedException {

    forks[philosopher].acquire();
    forks[(philosopher + 1) % 5].acquire();
    eaters.lock();
    pickLeftFork.run();
    pickRightFork.run();
    eat.run();
    putLeftFork.run();
    putRightFork.run();
    eaters.unlock();
    forks[philosopher].release();
    forks[(philosopher + 1) % 5].release();
  }
}
