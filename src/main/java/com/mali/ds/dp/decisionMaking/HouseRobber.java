package com.mali.ds.dp.decisionMaking;
/*
https://leetcode.com/problems/house-robber-ii/
medium
 */
public class HouseRobber {
  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(cal(nums, 0, nums.length - 1), cal(nums, 1, nums.length));
  }

  public static int rob_new(int[] nums) {
    return recursion(nums, 0, 0, new int[nums.length + 1][2]);
  }

  private static int recursion(int[] nums, int robbed, int i, int[][] dp) {
    if (i >= nums.length) return 0;
    if (dp[i][robbed] > 0) return dp[i][robbed];
    int ans2 = recursion(nums, 0, i + 1, dp);
    if (robbed == 0) {
      int ans1 = nums[i] + recursion(nums, 1, i + 1, dp);
      return dp[i][robbed] = Math.max(ans1, ans2);
    }
    return dp[i][robbed] = ans2;
  }

  public static int cal(int[] nums, int start, int end) {
    int curr = 0;
    int prev = 0;
    for (int i = start; i < end; i++) {
      int temp = curr;
      curr = Math.max(prev + nums[i], curr);
      prev = temp;
    }
    return curr;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 2};
    int[] nums1 = {1, 2, 3, 1};
    // System.out.println(rob(nums));
    System.out.println(rob(nums1));
    System.out.println(rob_new(nums1));
  }
}
