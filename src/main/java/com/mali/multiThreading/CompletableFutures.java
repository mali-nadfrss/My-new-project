package com.mali.multiThreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutures {

  Future<Integer> calculate(int i) {
    CompletableFuture<Integer> cp = new CompletableFuture<>();
    CompletableFuture<String> k =
        CompletableFuture.supplyAsync(() -> "hi").thenApply(r -> r + "there");

    // executors
    Executors.newSingleThreadExecutor() // new single thread executor
        .submit( // submit method t submit to executor
            () -> {
              try {
                Thread.sleep(10000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              // complete method used here
              cp.complete(i * i);
              return null;
            });
    return cp;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Future<Integer> i = new CompletableFutures().calculate(10);
    System.out.println(i.get()); // get method to get the result
  }
}
