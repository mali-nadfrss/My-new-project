package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/out-of-boundary-paths/
 * medium
 * */
public class OutOfBoundaryPaths {

  public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    return recursion(m, n, maxMove, startRow, startColumn, new int[m][n][maxMove + 1]);
  }

  static int recursion(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
    if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) return 1;
    if (maxMove <= 0) return 0;
    if (dp[startRow][startColumn][maxMove] > 0) return dp[startRow][startColumn][maxMove];
    final int MOD = 1000000007;
    int temp = recursion(m, n, maxMove - 1, startRow + 1, startColumn, dp) % MOD;

    temp = (temp + recursion(m, n, maxMove - 1, startRow - 1, startColumn, dp)) % MOD;
    temp = (temp + recursion(m, n, maxMove - 1, startRow, startColumn + 1, dp)) % MOD;
    temp = (temp + recursion(m, n, maxMove - 1, startRow, startColumn - 1, dp)) % MOD;
    dp[startRow][startColumn][maxMove] = temp % MOD;
    return dp[startRow][startColumn][maxMove];
  }

  public static void main(String[] args) {
    System.out.println(findPaths(8, 50, 23, 5, 26));
  }
}
