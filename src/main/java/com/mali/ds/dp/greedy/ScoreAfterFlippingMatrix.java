package com.mali.ds.dp.greedy;

/* https://leetcode.com/problems/score-after-flipping-matrix/
 * medium */
public class ScoreAfterFlippingMatrix {

  /* we need to toggle first column(if not 1 in horizontal way)
   as its weight is greater than all other numbers combined
  * then we need to toggle only in vertical way */
  public static int matrixScore(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      if (grid[i][0] != 1) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 0) {
            grid[i][j] = 1;
          } else {
            grid[i][j] = 0;
          }
        }
      }
    }
    int ans = 0;
    int j = 0;
    for (int i = 0; i < grid.length; i++) {
      int count = 0;
      for (; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          count += 1;
        }
        ans = (int) (Math.pow(2, grid.length-j-1)*Math.max(count, grid.length-count));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(matrixScore(new int[][] {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
  }
}
