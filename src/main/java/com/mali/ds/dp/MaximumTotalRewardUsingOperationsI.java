package com.mali.ds.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/maximum-total-reward-using-operations-i/description/
 * Hard */
public class MaximumTotalRewardUsingOperationsI {
  public static int maxTotalReward(int[] rewardValues) {

    Arrays.sort(rewardValues);
    int len = rewardValues.length;
    int[][] dp = new int[len][len];
    // for(int i = 0 ; i < len ; i++){
    dp[0][0] = rewardValues[0];

    for (int i = 0; i < len; i++) {
      // dp[i][i] = rewardValues[i];
      for (int j = 0; j <= i; j++) {
        //  dp[i][j] = rewardValues[i];
        if (dp[j][i] < rewardValues[i]) dp[i][j] = Math.max(dp[i][j], dp[j][i] + rewardValues[i]);
      }
    }
    int ans = 0;
    for (int i = 0; i < len; i++) {
      ans = Math.max(ans, dp[len - 1][i]);
    }
    return ans; // recursion(0, 0, rewardValues, dp);
  }

  public static void main(String[] args) {
    int[] r = {3, 4, 17, 11};
    maxTotalReward(r);
  }
}
