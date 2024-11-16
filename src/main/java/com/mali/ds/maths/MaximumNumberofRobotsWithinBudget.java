package com.mali.ds.maths;

import java.util.TreeMap;

public class MaximumNumberofRobotsWithinBudget {

  public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    int ans = 0;
    int start = 0;
    long costSum = 0;

    int count = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < chargeTimes.length; i++) {
      costSum += runningCosts[i];
      map.put(chargeTimes[i], map.getOrDefault(chargeTimes[i], 0) + 1);
      count++;
      while (map.size() > 0
          && map.floorEntry(Integer.MAX_VALUE).getKey() + count * costSum >= budget) {
        if (map.get(chargeTimes[start]) > 1) {
          map.put(chargeTimes[start], map.get(chargeTimes[start]) - 1);
        } else {
          map.remove(chargeTimes[start]);
        }
        count--;
        costSum -= runningCosts[start];
        start++;
      }
      ans = Math.max(ans, count);
    }
    ans = Math.max(ans, count);
    return ans;
  }

  public static void main(String[] args) {

    int[] chargeTimes = {11, 12, 19};
    int[] runningCosts = {10, 8, 7};
    int budget = 19;
    System.out.println(maximumRobots(chargeTimes, runningCosts, budget)); // 0
    int[] A = {8, 76, 74, 9, 75, 71, 71, 42, 15, 58, 88, 38, 56, 59, 10, 11};
    int[] B = {1, 92, 41, 63, 22, 37, 37, 8, 68, 97, 39, 59, 45, 50, 29, 37};
    System.out.println(maximumRobots(A, B, 412)); // 3
  }
}
