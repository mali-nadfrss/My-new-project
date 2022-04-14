package com.mali.ds.graph.bfs;

/* https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * medium */
public class ShortestPathInBinaryMatrix {
  static int n;

  public static int shortestPathBinaryMatrix(int[][] grid) {
    n = grid.length;
    if (grid[n - 1][n - 1] == 1 || grid[0][0] == 1) return -1;
    int[][] dp = new int[n][n];
    int ans = recursion(grid, n - 1, n - 1, dp);
    return ans > 10000 ? -1 : ans;
  }

  static int[][] dir = {
     {1, 0},
    {-1, 0},
     {0, 1},
    {0, -1},
    {-1, -1},
     {1, 1},
    {-1, 1},
     {1, -1}
  };

  public static int recursion(int[][] grid, int i, int j, int[][] dp) {
    if (i == 0 && j == 0 && grid[i][j] == 0) {
      return 1;
    }
    if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 1) {
      return 1000000;
    }
    int ans = Integer.MAX_VALUE;
    if (dp[i][j] > 0) return dp[i][j];

    for (int[] d : dir) {
      ans = Math.min(ans, 1 + recursion(grid, i + d[0], j + d[1], dp));
    }
    dp[i][j] = ans;
    return dp[i][j];
  }

  public static void main(String[] args) {
    int[][] days = {
      {0, 1, 1, 0, 0, 0},
      {0, 1, 0, 1, 1, 0},
      {0, 1, 1, 0, 1, 0},
      {0, 0, 0, 1, 1, 0},
      {1, 1, 1, 1, 1, 0},
      {1, 1, 1, 1, 1, 0}
    };
    int[][] days2 = {
      {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
      {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
      {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
      {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
      {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
    };
    System.out.println(shortestPathBinaryMatrix(days));
    System.out.println(shortestPathBinaryMatrix(days2));
  }
}
