package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/target-sum/
 * medium
 * */
public class TargetSum {
  public static int findTargetSumWays(int[] nums, int target) {
    return recursion(nums, 0, target, 0, 0);
  }

  static int recursion(int[] nums, int i, int target, int sum, int ans) {
    if (i >= nums.length && target == sum) {
      return 1;
    }
    if (i >= nums.length) {
      return 0;
    }
    return recursion(nums, i + 1, target, sum + nums[i], ans)
        + recursion(nums, i + 1, target, sum - nums[i], ans);
  }

  static int kanpsack(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum = sum + num;
    }
    if (sum < target) return 0;
    sum = sum + target;
    if (sum % 2 != 0 || sum < 0) return 0;
    sum /= 2;
    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int num : nums) {
      for (int i = sum; i >= num; i--) {
        dp[i] = dp[i] + dp[i - num];
      }
    }
    return dp[sum];
  }

  public static void main(String[] args) {
    int A[] = {1, 1, 1, 1, 1};
    System.out.println(findTargetSumWays(A, 3));
    System.out.println(kanpsack(A, 3));
    System.out.println(kanpsack(new int[] {1}, 1));
  }
}
