package com.mali.ds.trees.bt;

/* https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/ */
public class MinimumCostTreeFromLeafValues {

  public static int mctFromLeafValues(int[] arr) {
    int len = arr.length;
    int[][] dp = new int[len][len];
    return dfs(arr, 0, len - 1, dp);
  }

  static int dfs(int[] arr, int start, int end, int[][] dp) {

    if (start == end) return 0;
    if (dp[start][end] > 0) return dp[start][end];
    int ans = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      int left = dfs(arr, start, i, dp);
      int right = dfs(arr, i + 1, end, dp);
      int maxLeft = 0;
      int maxRight = 0;
      for (int j = start; j <= i; j++) {
        maxLeft = Math.max(maxLeft, arr[j]);
      }
      for (int j = i + 1; j <= end; j++) {
        maxRight = Math.max(maxRight, arr[j]);
      }
      ans = Math.min(ans, left + right + maxRight * maxLeft);
    }
    dp[start][end] = ans;
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(mctFromLeafValues(new int[] {6, 2, 4}));
  }
}
