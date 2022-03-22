package com.mali.ds.dp.max_min;

/*
https://leetcode.com/problems/maximal-square/
medium
 */
public class MaximalSquare {
  public static int maximalSquare(char[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int rLen = matrix.length;
    int cLen = matrix[0].length;
    int ans = 0;
    for (int i = rLen - 1; i >= 0; i--) {
      for (int j = cLen - 1; j >= 0; j--) {
        if (i == rLen - 1 || j == cLen - 1) {
          dp[i][j] = matrix[i][j] - '0';
        } else {
          dp[i][j] =
              matrix[i][j] - '0' > 0
                  ? 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]))
                  : 0;
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans * ans;
  }

  public static void main(String[] args) {
    char[][] nums = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    };
    System.out.println(maximalSquare(nums));
  }
}
