package com.mali.multiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

  ExecutorService es = Executors.newFixedThreadPool(1);

  Future<Integer> calculate(int i) {

    return es.submit(
        () -> {
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return i * i;
        });
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
      Futures f = new Futures();
      Future<Integer> k = f.calculate(9);
      while (!k.isDone()){
          System.out.println("calculating");
      }
      int h = k.get();
  }
}
