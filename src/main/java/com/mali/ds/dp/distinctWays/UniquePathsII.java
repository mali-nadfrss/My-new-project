package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/unique-paths-ii/
 * medium
 * */
public class UniquePathsII {

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    return recursion(m - 1, n - 1, obstacleGrid, new Integer[m][n]);
  }

  static int recursion(int m, int n, int[][] obstacleGrid, Integer[][] dp) {
    if (obstacleGrid[m][n] == 1) {
      return 0;
    } else if (m == 0 && n == 0) {
      return 1;
    } else if (dp[m][n] != null) {
      return dp[m][n];
    } else if (m == 0) {
      dp[m][n] = recursion(m, n - 1, obstacleGrid, dp);
    } else if (n == 0) {
      dp[m][n] = recursion(m - 1, n, obstacleGrid, dp);
    } else {
      dp[m][n] = recursion(m - 1, n, obstacleGrid, dp) + recursion(m, n - 1, obstacleGrid, dp);
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
  }
}
