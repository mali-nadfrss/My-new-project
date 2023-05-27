package com.mali.ds.graph.bfs;

import java.util.Arrays;

/* https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/ */
public class MinimumCosttoMakeatLeastOneValidPathinaGrid {

  public int minCost(int[][] grid) {
    this.grid = grid;
    col = grid[0].length;
    row = grid.length;
    dp = new int[row][col];
    for (int i = 0; i < row; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    vis = new int[row][col];
    int ans = recursion(0, 0);
    return ans;
  }

  int col;
  int row;
  int[][] dp;
  int[][] grid;
  int[][] vis;

  int recursion(int i, int j) {
    if (i == row - 1 && j == col - 1) {
      return dp[i][j] = 1;
    }
    if (i < 0 || j < 0 || i >= row || j >= col) return Integer.MAX_VALUE;
    if (vis[i][j] == 1) return dp[i][j];
    vis[i][j] = 1;
    // down
      dp[i][j] = Math.min(dp[i][j], recursion(i + 1, j) + grid[i][j] == 3 ? 0 : 1);
    // left
      dp[i][j] = Math.min(dp[i][j], recursion(i, j - 1) + grid[i][j] == 2 ? 0 : 1);
    // right
      dp[i][j] = Math.min(dp[i][j], recursion(i, j + 1) + grid[i][j] == 1 ? 0 : 1);
    return dp[i][j];
  }

  public static void main(String[] args) {
    MinimumCosttoMakeatLeastOneValidPathinaGrid m =
        new MinimumCosttoMakeatLeastOneValidPathinaGrid();
    int[][] grid = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
    m.minCost(grid);
  }
}
