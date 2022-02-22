package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/combination-sum-iv/
 * medium
 * */
public class CombinationSumIV {
  public static int combinationSum4(int[] nums, int target) {
    return recursion(nums, target, new int[target+1]);
  }

  static int recursion(int[] nums, int target, int[] dp) {
    if (0 > target) return 0;
    if (0 == target) return 1;
    if (dp[target] > 0) return dp[target];
    int ans = 0;
    for (int num : nums) {
      ans = ans + recursion(nums, target - num, dp);
    }
    return dp[target] = ans;
  }

  public static void main(String[] args) {
    System.out.println(combinationSum4(new int[] {1, 2, 3}, 4));
  }
}
