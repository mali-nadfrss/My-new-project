package com.mali.ds.Queues;

import java.util.*;

public class KMostFrequentQImpl {

  static void logic(int[] arr, int k) {

    Map<Integer, Integer> m = new HashMap<>();
    for (int i : arr) {
      if (m.containsKey(i)) {
        m.put(i, m.get(i) + 1);
      } else {
        m.put(i, 1);
      }
    }

    Queue<Map.Entry<Integer, Integer>> q =
        new PriorityQueue<>(
            (a, b) ->
                a.getValue().equals(b.getValue())
                    ? b.getKey().compareTo(a.getKey())
                    : b.getValue().compareTo(a.getValue()));
    q.addAll(m.entrySet());

    for (int i = 0; i < k; i++) {
      System.out.println(Objects.requireNonNull(q.poll()).getKey());
    }
  }

  public static void main(String args[]) {
    int[] arr = {1, 2, 3, 5, 4, 4, 5, 1, 1, 1};
    logic(arr, 3);
  }
}
