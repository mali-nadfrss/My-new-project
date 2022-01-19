package com.mali.ds.dp;

/*
https://leetcode.com/problems/minimum-falling-path-sum/
Medium
 */

public class MinimumFallingPathSum {
  public static int minFallingPathSum(int[][] matrix) {
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j == 0) {
          matrix[i][j] =
              Math.min(matrix[i - 1][j] + matrix[i][j], matrix[i - 1][j + 1] + matrix[i][j]);
        } else if (j == matrix[0].length - 1) {
          matrix[i][j] =
              Math.min(matrix[i - 1][j] + matrix[i][j], matrix[i - 1][j - 1] + matrix[i][j]);
        } else {
          matrix[i][j] =
              Math.min(
                  matrix[i - 1][j - 1] + matrix[i][j],
                  Math.min(matrix[i - 1][j] + matrix[i][j], matrix[i - 1][j + 1] + matrix[i][j]));
        }
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < matrix[0].length; i++) {
      if (ans > matrix[matrix.length - 1][i]) {
        ans = matrix[matrix.length - 1][i];
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[][] days = {{-19, 57}, {-40, -5}};
    System.out.println(minFallingPathSum(days));
  }
}
