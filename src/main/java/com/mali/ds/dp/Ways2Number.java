package com.mali.ds.dp;

import java.util.Arrays;

public class Ways2Number {

  static int way(int n, int[] nums, int[] dp) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (dp[n] != 0) {
      return dp[n];
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      ans = ans + way(n - nums[i], nums, dp);
    }
    dp[n] = ans;
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    Arrays.sort(nums);
    int[] dp = new int[nums[nums.length - 1] + 1];
    System.out.println(way(3, nums, dp));
  }
}
