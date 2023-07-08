package com.mali.ds.dp;

import java.util.Arrays;

public class MinCoinSum {

  // bottom up dp
  static int minCoinsBottomUp(int[] change, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i < amount; i++) {
      dp[i] = dp.length;
      for (int j = 0; j < change.length; j++) {
        if (i >= change[j]) dp[i] = Math.min(dp[i], dp[i - change[j]] + 1);
      }
    }
    if (dp[amount] == dp.length) return -1;
    return dp[amount];
  }

  // recursion
  static int minCoinsRecursion(int[] change, int amount) {
    int[][] dp = new int[change.length][amount + 1];
    return recursion(0, change, amount, dp);
  }

  static int recursion(int index, int[] change, int amount, int[][] dp) {
    if (amount < 0) return Integer.MAX_VALUE / 2;
    if (amount == 0) return 0;
    if (index >= change.length) return Integer.MAX_VALUE / 2;
    if (dp[index][amount] > 0) return dp[index][amount];
    return dp[index][amount] =
        Math.min(
            recursion(index, change, amount - change[index], dp) + 1,
            recursion(index + 1, change, amount, dp));
  }

  static int minCoins(int[] change, int amount) {

    int l = change.length;
    int[][] ans = new int[l][amount + 1];
    Arrays.sort(change);
    for (int i = 0; i <= amount; i++) {
      if (i % change[0] == 0) {
        ans[0][i] = i / change[0];
      } else {
        ans[0][i] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1; i < l; i++) {
      for (int j = 0; j <= amount; j++) {
        if (change[i] > j) {
          ans[i][j] = ans[i - 1][j];
        } else {
          ans[i][j] = Integer.min(1 + ans[i][j - change[i]], ans[i - 1][j]);
        }
      }
    }
    return ans[l - 1][amount];
  }

  public static void main(String[] args) {
    int[] change = {1, 2, 5, 10, 20, 50, 100};
    int amount = 48;
    System.out.println(minCoins(change, amount));
    System.out.println(minCoinsRecursion(change, amount));
  }
}
