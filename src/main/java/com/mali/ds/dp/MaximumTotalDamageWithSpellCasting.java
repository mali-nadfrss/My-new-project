package com.mali.ds.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/
 * Hard */
public class MaximumTotalDamageWithSpellCasting {
    public static long maximumTotalDamage(int[] power) {
      Arrays.sort(power);
      int len = power.length;
      long[][] dp = new long[len][len];
      long ans = 0l;
      for (int i = 0; i < len; i++) {
        ans = Math.max(ans, recursion(i, i,  power, dp));
      }
      return ans;
    }

    static long recursion(int i, int prev, int[] power, long[][] dp) {
      if (i >= power.length) {
        return 0;
      }
      if (dp[i][prev] > 0) return dp[i][prev];
      if (power[i] == power[prev]) {
        dp[i][prev] = power[i]+ recursion(i + 1, i, power, dp);
      } else if (power[i] - power[prev] > 2) {
        dp[i][prev] =
            Math.max(
                power[i]+recursion(i + 1, i, power, dp),
                recursion(i + 1, prev, power, dp));
      } else dp[i][prev] = recursion(i + 1, prev, power, dp);

      return dp[i][prev];
    }

  public static void main(String[] args) {
    int[] arr = {5, 9, 2, 10, 2, 7, 10, 9, 3, 8};
    maximumTotalDamage(arr);
  }
}
