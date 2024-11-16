package com.mali.ds.dp.distinctWays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/unique-paths/
 * medium
 * */
public class UniquePaths {

  public static int uniquePaths(int m, int n) {
    int[] dp = new int [n];
    Arrays.fill(dp, 1);
    for (int i = m - 2; i >= 0; i--) {
      int next = 0;
      int[] temp = new int [n];
      for (int j = n - 1; j >= 0; j--) {
        next = temp[j] = dp[j]+next;
      }
      dp = temp;
    }
    System.out.println(dp[0]);
    return recursion(m - 1, n - 1, new Integer[m][n]);
  }

  static int recursion(int m, int n, Integer[][] dp) {
    // base condition: ways to reach the start position is 1
    if (m == 0 && n == 0) {
      return 1;
    } else if (dp[m][n] != null) {
      // results are stored in dp already return
      return dp[m][n];
    } else if (m == 0) {
      // if m == 0 that means we are at 1 edge , so we can reach here only 1 way
      // which is same as way above it so just return n-1 ways
      dp[m][n] = recursion(m, n - 1, dp);
    } else if (n == 0) {
      // if n == 0 that means we are at another edge , so we can reach here only 1 way
      // which is same as previous way so just return n-1 ways
      dp[m][n] = recursion(m - 1, n, dp);
    } else {
      // here comes actual logic: we can reach each square in 2 ways(side or up)
      // return sum of ways to reach side and up
      // in next iteration we can calculate side and up ways
      dp[m][n] = recursion(m - 1, n, dp) + recursion(m, n - 1, dp);
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 2));
  }
}
