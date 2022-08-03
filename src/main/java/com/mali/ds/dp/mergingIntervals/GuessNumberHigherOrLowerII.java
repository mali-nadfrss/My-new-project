package com.mali.ds.dp.mergingIntervals;

/* https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * medium
 * */
public class GuessNumberHigherOrLowerII {

  // merge each subproblem and find max
  public static int getMoneyAmount(int n) {
    return recursionSubProblem(1, n, new int[n + 1][n + 1]);
  }

  static int recursionSubProblem(int start, int end, int[][] dp) {
    if (start >= end || start <= 0) {
      return 0;
    }
    if (dp[start][end] > 0) return dp[start][end];
    int ans = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      ans =
          Math.min(
              ans,
              i
                  + Math.max(
                      recursionSubProblem(start, i - 1, dp), recursionSubProblem(i + 1, end, dp)));
    }
    dp[start][end] = ans;
    return dp[start][end];
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
      System.out.println(getMoneyAmount(i));
    }
  }
}
