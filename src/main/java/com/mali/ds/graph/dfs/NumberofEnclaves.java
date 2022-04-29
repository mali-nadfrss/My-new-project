package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/number-of-enclaves/
 * medium */
public class NumberofEnclaves {
  static int v;
  static int h;

  public static int numEnclaves(int[][] grid) {
    v = grid.length;
    h = grid[0].length;
    int i = 0, j = 0;
    for (i = 0; i < v; i++) {
      for (j = 0; j < h; j++) {
        if (i == 0 || j == 0 || i == v - 1 || j == h - 1) {
          dfs(grid, i, j);
        }
      }
    }

    int ans = 0;

    for (i = 1; i < v - 1; i++) {
      for (j = 1; j < h - 1; j++) {
        if (grid[i][j] == 1) {
          ans++;
        }
      }
    }
    return ans;
  }

  static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  static void dfs(int[][] grid, int i, int j) {
    if (i >= 0 && j >= 0 && i < v && j < h && grid[i][j] == 1) {
      grid[i][j] = 0;
      for (int[] d : dir) {
        dfs(grid, i + d[0], j + d[1]);
      }
    }
  }

  public static void main(String[] args) {
    int[][] days = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
    int[][] days2 = {
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
      {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
      {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
      {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
      {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}
    };
    // System.out.println(numEnclaves(days));
    System.out.println(numEnclaves(days2));
  }
}
