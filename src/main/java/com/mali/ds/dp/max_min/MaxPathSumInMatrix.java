package com.mali.ds.dp.max_min;

/* https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */
public class MaxPathSumInMatrix {

  public static int getMaxPathSum(int[][] matrix) {
    // Write your code here

    int n = matrix.length;
    int m = matrix[0].length;

    int[] dp = new int[m];

    for (int i = 0; i < n; i++) {
      int[] tdp = new int[m];
      for (int j = 0; j < m; j++) {
        int k;
        if (j == 0) {
          k = Math.max(dp[j], dp[j + 1]);
        } else if (j == m - 1) {
          k = Math.max(dp[j - 1], dp[j]);
        } else {
          k = Math.max(dp[j], Math.max(dp[j - 1], dp[j + 1]));
        }
        tdp[j] = matrix[i][j] + k;
      }
      dp = tdp;
    }

    int ans = Integer.MIN_VALUE;
    for (int i : dp) {
      ans = Math.max(i, ans);
    }

    return ans;
  }

  public static void main(String[] args) {

      int[][] matrix = {{-9999, -9888, -9777, -9666, -9555}};

      getMaxPathSum(matrix);

  }
}
