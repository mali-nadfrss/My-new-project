package com.mali.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/maximum-profit-in-job-scheduling/ */
public class MaximumProfitinJobScheduling {

  public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

    Map<Integer, List<int[]>> map = new HashMap<>();

    for (int i = 0; i < startTime.length; i++) {
      map.putIfAbsent(startTime[i], new ArrayList<>());
      map.get(startTime[i]).add(new int[] {startTime[i], endTime[i], profit[i]});
    }

    int[] dp = new int[100002];

    for (int i = 100000; i >= 0; i--) {
      dp[i] = dp[i + 1];
      if (map.get(i) != null) {
        for (int[] arr : map.get(i)) {
          dp[i] = Math.max(dp[i], arr[2] + dp[arr[1]]);
        }
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
    jobScheduling(startTime, endTime, profit);
  }
}
