package com.mali.ds.dp.max_min;

/*
https://leetcode.com/problems/minimum-path-sum/
medium
 */
public class MinPathSum {

  public static int minPathSum(int[][] grid) {
    return backtracking(grid, 0, 0, new int[grid.length][grid[0].length]);
  }

  public static int backtracking(int[][] grid, int i, int j, int[][] dp) {
    if (i == dp.length - 1 && j == dp[0].length - 1) {
      return grid[i][j];
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    int min = Integer.MAX_VALUE;
    if (i + 1 < grid.length) {
      min = Math.min(backtracking(grid, i + 1, j, dp), min);
    }
    if (j + 1 < grid[0].length) {
      min = Math.min(backtracking(grid, i, j + 1, dp), min);
    }
    dp[i][j] = min + grid[i][j];
    return dp[i][j];
  }

  public static int tabulation(int[][] grid) {
    int rowLen = grid.length - 1;
    int colLen = grid[0].length - 1;
    int[][] dp = new int[rowLen + 1][colLen + 1];
    for (int i = rowLen; i >= 0; i--) {
      for (int j = colLen; j >= 0; j--) {
        if (i == rowLen && j == colLen) {
          dp[i][j] = grid[i][j];
        } else if (i == rowLen) {
          dp[i][j] = dp[i][j + 1] + grid[i][j];
        } else if (j == colLen) {
          dp[i][j] = dp[i + 1][j] + grid[i][j];
        } else {
          dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }
    return dp[0][0];
  }

  public static void main(String[] args) {
    int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(tabulation(nums));
    System.out.println(minPathSum(nums));
  }
}
