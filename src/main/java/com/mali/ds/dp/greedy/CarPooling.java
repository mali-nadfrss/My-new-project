package com.mali.ds.dp.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/car-pooling/
 * medium */
public class CarPooling {
  public static boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
    PriorityQueue<int[]> priorityQueue =
        new PriorityQueue(
            (o1, o2) ->
                ((int[]) o2)[2] == ((int[]) o1)[2]
                    ? ((int[]) o1)[0] - ((int[]) o2)[0]
                    : ((int[]) o1)[2] - ((int[]) o2)[2]);
    int pas = 0;
    for (int i = 0; i < trips.length; i++) {
      if (pas > capacity) return false;
      while (!priorityQueue.isEmpty() && priorityQueue.peek()[2] <= trips[i][1]) {
        int[] arr = priorityQueue.poll();
        pas -= arr[0];
      }
      priorityQueue.offer(trips[i]);
      pas += trips[i][0];
    }
    return pas <= capacity;
  }

  public static void main(String[] args) {
    System.out.println(carPooling(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
  }
}
