package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/number-of-closed-islands/
 * medium */
public class NumberofClosedIslands {

  static boolean flag = true;

  public static int closedIsland(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          dfs(grid, i, j);
          if (flag) ans++;
        }
        flag = true;
      }
    }
    return ans;
  }

  static void dfs(int[][] grid, int i, int j) {

    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
      return;
    }
    if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
      flag = false;
    }
    grid[i][j] = 1;

    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }

  public static void main(String[] args) {
    int[][] days = {
      {1, 1, 1, 1, 1, 1, 1, 0},
      {1, 0, 0, 0, 0, 1, 1, 0},
      {1, 0, 1, 0, 1, 1, 1, 0},
      {1, 0, 0, 0, 0, 1, 0, 1},
      {1, 1, 1, 1, 1, 1, 1, 0}
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
    System.out.println(closedIsland(days));
    System.out.println(closedIsland(days2));
  }
}
