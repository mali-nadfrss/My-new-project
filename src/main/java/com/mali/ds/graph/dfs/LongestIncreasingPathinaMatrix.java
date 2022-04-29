package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Hard */
public class LongestIncreasingPathinaMatrix {

  public static int longestIncreasingPath(int[][] matrix) {
    int ans = 0;
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        ans = Math.max(dfs(matrix, i, j, visited, dp, Integer.MIN_VALUE), ans);
      }
    }
    return ans;
  }

  static int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] dp, int value) {
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= value) {
      return 0;
    }
    if (visited[i][j]) {
      return dp[i][j];
    }
    visited[i][j] = true;
    int ans = 0;
    ans = Math.max(ans, dfs(matrix, i + 1, j, visited, dp, matrix[i][j]));
    ans = Math.max(ans, dfs(matrix, i - 1, j, visited, dp, matrix[i][j]));
    ans = Math.max(ans, dfs(matrix, i, j + 1, visited, dp, matrix[i][j]));
    ans = Math.max(ans, dfs(matrix, i, j - 1, visited, dp, matrix[i][j]));
    dp[i][j] = ans + 1;
    return ans + 1;
  }

  public static void main(String[] args) {
    int[][] days = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
    System.out.println(longestIncreasingPath(days));
  }
}
