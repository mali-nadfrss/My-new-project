package com.mali.ds.graph.bfs;

/* https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/ */
public class MinimumMovestoSpreadStonesOverGrid {

  public static int minimumMoves(int[][] grid) {
    return recursion(grid, new int[3][3]);
  }

  static int recursion(int[][] grid, int[][] vis) {

    int flag = 0;
    int ans1 = 0;
    int ans2 = 0;
    int ans3 = 0;
    int ans4 = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j] == 0 && vis[i][j] == 0) {
          flag = 1;
          if ( grid[i - 1][j] > 0 && vis[i - 1][j] == 0) {
            grid[i][j] = 1;
            grid[i - 1][j] = grid[i - 1][j] - 1;
            vis[i][j] = 1;
            ans1 = 1 + recursion(grid, vis);
            grid[i][j] = 0;
            grid[i - 1][j] += 1;
            vis[i][j] = 0;
          } else {
            ans1 = 1000;
          }
          if (grid[i][j] == 0 && j > 0 && grid[i][j - 1] > 0 && vis[i][j - 1] == 0) {
            grid[i][j] = 1;
            grid[i][j - 1] = grid[i][j - 1] - 1;
            vis[i][j] = 1;
            ans2 = 1 + recursion(grid, vis);
            grid[i][j] = 0;
            grid[i][j - 1] += 1;
            vis[i][j] = 0;
          } else {
            ans2 = 1000;
          }
          if (grid[i][j] == 0 && i < 2 && grid[i + 1][j] > 0 && vis[i + 1][j] == 0) {
            grid[i][j] = 1;
            grid[i + 1][j] = grid[i + 1][j] - 1;
            vis[i][j] = 1;
            ans3 = 1 + recursion(grid, vis);
            grid[i][j] = 0;
            grid[i + 1][j] += 1;
            vis[i][j] = 0;
          } else {
            ans3 = 1000;
          }
          if (grid[i][j] == 0 && j < 2 && grid[i][j + 1] > 0 && vis[i][j + 1] == 0) {
            grid[i][j] = 1;
            grid[i][j + 1] = grid[i][j + 1] - 1;
            vis[i][j] = 1;
            ans4 = 1 + recursion(grid, vis);
            grid[i][j] = 0;
            grid[i][j + 1] += 1;
            vis[i][j] = 0;
          } else {
            ans4 = 1000;
          }
        }
      }
    }
    if (flag == 0) return 0;

    return Math.min(ans1, Math.min(ans2, Math.min(ans3, ans4)));
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 3}, {1, 0, 0}, {0, 1, 0}};
    System.out.println(minimumMoves(grid));
  }
}
