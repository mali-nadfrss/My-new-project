package com.mali.ds.dp.max_min;

/* https://www.codingninjas.com/studio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */
public class ChocolatePickup {

  public static int maximumChocolates(int r, int c, int[][] grid) {
    // Write your code here.
    int[][][] dp = new int[r][c][c];

    dp[0][0][0] = grid[0][0];
    dp[0][0][c - 1] = grid[0][c - 1];


    return recursion(0, 0, c - 1, grid, dp);
  }

  static int recursion(int i, int j1, int j2, int[][] grid, int[][][] dp) {
    if (i == grid.length || j1 < 0 || j2 < 0 || j1 == grid[0].length || j2 == grid[0].length)
      return Integer.MIN_VALUE;

    if (i == grid.length - 1) {
      if (j1 == j2) return grid[i][j1];
      else return grid[i][j1] + grid[i][j2];
    }

    if (dp[i][j1][j2] > 0) return dp[i][j1][j2];
    int k1;
    if (j1 != j2) k1 = grid[i][j1] + grid[i][j2];
    else k1 = grid[i][j1];

    int k = recursion(i + 1, j1, j2, grid, dp);
    k = Math.max(k, recursion(i + 1, j1 - 1, j2, grid, dp));
    k = Math.max(k, recursion(i + 1, j1 + 1, j2, grid, dp));
    k = Math.max(k, recursion(i + 1, j1, j2 - 1, grid, dp));
    k = Math.max(k, recursion(i + 1, j1 - 1, j2 - 1, grid, dp));
    k = Math.max(k, recursion(i + 1, j1 + 1, j2 - 1, grid, dp));
    k = Math.max(k, recursion(i + 1, j1, j2 + 1, grid, dp));
    k = Math.max(k, recursion(i + 1, j1 - 1, j2 + 1, grid, dp));
    k = Math.max(k, recursion(i + 1, j1 + 1, j2 + 1, grid, dp));

    return dp[i][j1][j2] = k1 + k;
  }

  public static void main(String[] args) {
    int[][] grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
    System.out.println(maximumChocolates(3, 4, grid));
  }
}
