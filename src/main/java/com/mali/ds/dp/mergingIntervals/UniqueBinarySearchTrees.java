package com.mali.ds.dp.mergingIntervals;

/*
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Medium
 * */
public class UniqueBinarySearchTrees {

  /*
   *  explanation: dp[0] = 1; dp[1] = 1 , dp[2] = 2, dp[3] = 5
   *  for 4, possible combinations
   *  1        2       3      4
   *    \     / \     / \    /
   *     ..   1  ..  ..  4   ..
   * .. implies rest of the tree
   * so for 1 above its rights side * left side combinations = dp[0] * dp[3]
   * for 2 : dp[1]*dp[2] .. for 3 : dp[2]*dp[1] .. for 4 : dp[3]*dp[0]
   * */
  public static int numTrees(int n) {
    int[] dp = new int[n + 2];
    dp[0] = dp[1] = 1;
    for (int i = 2; i <= n+1; i++) {
      for (int j = 1; j < i; j++) {
        dp[i] = dp[i] + (dp[i - j] * dp[j]);
      }
    }
    return dp[n+1];
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) {
      System.out.println(numTrees(i));
    }
  }
}
