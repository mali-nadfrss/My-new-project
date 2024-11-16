package com.mali.ds.dp.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPlatformsProblem {

  static int minimumPlatformsProblem(int[] arr, int[] dept, int n) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[][] sched = new int[n][2];

    for (int i = 0; i < n; i++) {
      sched[i][0] = arr[i];
      sched[i][1] = dept[i];
    }
    Arrays.sort(sched, Comparator.comparingInt(o -> o[0]));
    int ans = 0;
    for (int i = 0; i < n; i++) {
      while (!pq.isEmpty() && pq.peek() < sched[i][0]) {
        pq.poll();
      }
      pq.add(sched[i][1]);
      ans = Math.max(ans, pq.size());
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    int arr[] = {900, 1100, 1235};
    int dep[] = {1000, 1200, 1240};
    minimumPlatformsProblem(arr, dep, n);
  }
}
