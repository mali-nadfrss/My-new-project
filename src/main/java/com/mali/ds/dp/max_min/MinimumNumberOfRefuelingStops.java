package com.mali.ds.dp.max_min;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/minimum-number-of-refueling-stops/
Hard
 */
public class MinimumNumberOfRefuelingStops {
  public static int minRefuelStops(int target, int startFuel, int[][] stations) {
    Queue<Integer> q = new PriorityQueue<>();
    if (startFuel >= target) {
      return 0;
    }
    int ans = 0;
    int i = 0;
    int maxDistance = startFuel;
    while (true) {
      while (i < stations.length && startFuel > stations[i++][0]) {
        startFuel = startFuel - stations[i][0];
        maxDistance = maxDistance + stations[i][0];
        q.add(stations[i][1]);
      }
      if (target <= maxDistance) return ans;
      if (q.isEmpty()) return -1;
      startFuel = startFuel + q.poll();
      ans++;
    }
  }

  public static void main(String[] args) {
    int[][] days = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
    System.out.println(minRefuelStops(100, 10, days));
  }
}
