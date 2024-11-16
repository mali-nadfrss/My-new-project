package com.mali.ds.dp;

/* https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid/description/ */
public class MinimumNumberofVisitedCellsInAGrid {

  public static int minimumVisitedCells(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    int[][][] dp = new int[row][col][3];
    dp[row - 1][col - 1] = new int[] {1, 0, 0};

    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        calRes(i, j, grid[i][j], dp, row, col);
      }
    }
    System.out.println(dp[0][0][0]);
    return dp[0][0][0] == Integer.MAX_VALUE ? -1 : dp[0][0][0];
  }

  static int calHor(int index, int[][][] dp, int val, int max, int row) {

    int ans = Integer.MAX_VALUE;
    for (int i = index + 1; i < max && i <= index + val; i++) {
      ans = dp[row][i][0] > -1 ? Math.min(ans, dp[row][i][0] + 1) : ans;
    }
    dp[row][index][1] = index + val;
    return ans;
  }

  static int calVer(int index, int[][][] dp, int val, int max, int col) {

    int ans = Integer.MAX_VALUE;
    for (int i = index + 1; i < max && i <= index + val; i++) {
      ans = dp[i][col][0] > -1 ? Math.min(ans, dp[i][col][0] + 1) : ans;
    }
    dp[index][col][2] = index + val;
    return ans;
  }

  static void calRes(int i, int j, int val, int[][][] dp, int row, int col) {

    if (dp[i][j][0] > 0) return;
    int ans = i + 1 < row ? dp[i + 1][j][0] : Integer.MAX_VALUE;
    int temp = j + 1 < col ? dp[j + 1][j][0] : Integer.MAX_VALUE;
    if (i + 1 < row && dp[i + 1][j][1] < i + val) {
      ans = Math.min(calHor(j, dp, val, col, i), ans);
    }
    if (j + 1 < col && dp[i][j + 1][2] < j + val) {
      temp = Math.min(calVer(i, dp, val, row, j), temp);
    }
    if (temp == Integer.MAX_VALUE) dp[i][j][0] = ans;
    if (ans == Integer.MAX_VALUE) dp[i][j][0] = temp;
    dp[i][j][0] = Math.min(ans, temp);
  }

  public static void main(String[] args) {
    int[][] grid = {{3, 4, 2, 1}, {4, 2, 1, 1}, {2, 1, 1, 0}, {3, 4, 1, 0}};
    minimumVisitedCells(grid);
  }
}
