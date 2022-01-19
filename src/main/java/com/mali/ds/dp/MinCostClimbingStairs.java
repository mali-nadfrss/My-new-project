package com.mali.ds.dp;

public class MinCostClimbingStairs {
  public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length];
    return Math.min(recursive(dp, cost, 0), recursive(dp, cost, 1));
  }

  static int recursive(int[] dp, int[] cost, int i) {
    if (i >= cost.length) {
      return 0;
    }
    if (dp[i] != 0) {
      return dp[i];
    }
    dp[i] = cost[i] + Math.min(recursive(dp, cost, i + 1), recursive(dp, cost, i + 2));
    return dp[i];
  }

  static int normal(int[] costs) {
    int first = costs[0];
    int second = costs[1];
    if (costs.length == 2) {
      return Math.min(first, second);
    }
    for (int i = 2; i < costs.length; i++) {
      int curr = costs[i] + Math.min(first, second);
      first = second;
      second = curr;
    }
    return Math.min(first, second);
  }

  public static void main(String[] args) {
    int[] days = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(minCostClimbingStairs(days));
    System.out.println(normal(days));
  }
}
