package com.mali.ds.maths;

import java.util.PriorityQueue;

public class MaximumNumberofRobotsWithinBudget {

  public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    int ans = 0, j = -1;
    long s = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
    for (int i = 0; i < runningCosts.length; i++) {
      s += runningCosts[i];
      pq.offer(new int[] {chargeTimes[i], i});
      while (s * (i - j) + removeStale(pq, j) > budget) s -= runningCosts[++j];
      ans = Math.max(ans, i - j);
    }
    return ans;
  }

  private static int removeStale(PriorityQueue<int[]> pq, int j) {
    while (!pq.isEmpty() && pq.peek()[1] <= j) pq.poll();
    if (pq.isEmpty()) return 0;
    return pq.peek()[0];
  }

  public static void main(String[] args) {

    int[] A = {8, 76, 74, 9, 75, 71, 71, 42, 15, 58, 88, 38, 56, 59, 10, 11};
    int[] B = {1, 92, 41, 63, 22, 37, 37, 8, 68, 97, 39, 59, 45, 50, 29, 37};
    System.out.println(maximumRobots(A, B, 412));
  }
}
