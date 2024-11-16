package com.mali.ds.graph.dfs;

/* https://leetcode.com/contest/biweekly-contest-97/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/ */
public class DisconnectPathinaBinaryMatrixbyatMostOneFlip {

  public static boolean isPossibleToCutPath(int[][] grid) {

    dfs(grid, 0, 0);
    grid[0][0] = 1;
    return !dfs(grid, 0, 0);
  }

  static boolean dfs(int[][] grid, int i, int j) {
    if (i >= grid.length || j >= grid[0].length) return false;
    if (grid[i][j] == 0) return false;
    if (i == grid.length - 1 && j == grid[0].length - 1) return true;
    grid[i][j] = 0;
    return dfs(grid, i + 1, j) || dfs(grid, i, j + 1);
  }

  public static void main(String[] args) {
    int[][] grid = {
      {1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}
    };

    int[][] grid1 = {{1, 1, 1}, {1, 0, 0}, {1, 1, 1}};
    int[][] grid2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    System.out.println(isPossibleToCutPath(grid));
  }
}
