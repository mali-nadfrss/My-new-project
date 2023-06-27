package com.mali.ds.dp.distinctWays;

import java.util.Arrays;

/* https://leetcode.com/contest/weekly-contest-350/problems/special-permutations/ */
public class SpecialPermutations {

  public static final int MOD = 1000000007;

  public static int specialPerm(int[] nums, int index, int previous, int used, int[][] dp) {

    if (index >= nums.length) {
      return 1;
    }
    if (dp[index][used] > -1) return dp[index][used];
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((used & 1 << i) == 0
          && (nums[previous] % nums[i] == 0 || nums[i] % nums[previous] == 0)) {
        used |= 1 << i;
        count += specialPerm(nums, index + 1, i, used, dp);
        count %= MOD;
        used &= ~(1 << i);
      }
    }
    return dp[index][used] = count;
  }

  public static int specialPerm(int[] nums) {

    int[][] dp = new int[15][1 << nums.length];

    for (int[] j : dp) {
      Arrays.fill(j, -1);
    }

    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      int used = 0;
      used |= 1 << i;
      ans += specialPerm(nums, 1, i, used, dp) % MOD;
      ans %= MOD;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};

    System.out.println(specialPerm(nums));
  }
}
