package com.mali.ds.dp.bruteForce;

/*
 * https://leetcode.com/problems/unique-paths-iii/
 * hard
 * */
public class UniquePathsIII {

  public static int uniquePathsIII(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    int x = 0;
    int y = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          x = i;
          y = j;
        }
        if (grid[i][j] == 0 || grid[i][j] ==1) {
          count++;
        }
      }
    }
    return recursion(x, y, grid, new int[m][n], new Integer[m][n], count);
  }

  static int recursion(int m, int n, int[][] grid, int[][] traversed, Integer[][] dp, int count) {
    int ans;
    if (m < 0
        || n < 0
        || m >= grid.length
        || n >= grid[0].length
        || grid[m][n] == -1
        || traversed[m][n] == 1) {
      // if already traversed its not a viable path
      // or there is some obstacle
      // if m or n < 0 or m > length --> we cannot traverse for negative paths
      // return 0
      return 0;
    } else if (grid[m][n] == 2) {
      // this will end point, it can be anywhere in the grid
      // return only if we have traversed all the points in grid
      if (count <= 0) {
        return 1;
      } else {
        return 0;
      }
    } else {
      // mark it as traversed upfront as we are calculating for it below
      traversed[m][n] = 1;
      count--;
      ans = // calculate the sum in all 4 directions
          recursion(m - 1, n, grid, traversed, dp, count)
              + recursion(m + 1, n, grid, traversed, dp, count)
              + recursion(m, n - 1, grid, traversed, dp, count)
              + recursion(m, n + 1, grid, traversed, dp, count);
      traversed[m][n] = 0; // set it back to original state as others need to go in same path
      count++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
    System.out.println(uniquePathsIII(grid));
    System.out.println(uniquePathsIII(new int[][] {{0, 1}, {2, 0}}));
    System.out.println(uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
  }
}
