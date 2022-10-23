package com.mali.ds.arrays;

/* https://leetcode.com/problems/range-sum-query-2d-immutable/ */
public class RangeSumQuery2DImmutable {

  int[][] sum;

  public RangeSumQuery2DImmutable(int[][] matrix) {

    int rl = matrix.length;
    int cl = matrix[0].length;
    sum = new int[rl + 1][cl + 1];
    sum[0][0] = matrix[0][0];

    for (int i = 1; i < cl; i++) {
      sum[0][i] = sum[0][i - 1] + matrix[0][i];
    }

    for (int i = 1; i < rl; i++) {
      sum[i][0] = sum[i - 1][0] + matrix[i][0];
    }

    for (int i = 1; i < rl; i++) {
      for (int j = 1; j < cl; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {

    return sum[row2][col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
  }

  public static void main(String[] args) {
    int[][] nums = {
      {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
    };

    RangeSumQuery2DImmutable r = new RangeSumQuery2DImmutable(nums);
    r.sumRegion(2, 1, 4, 3);
  }
}
