package com.mali.ds.dp;
/*
https://leetcode.com/problems/house-robber-ii/
medium
 */
public class HouseRobber {
  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(cal(nums, 0, nums.length-1) , cal(nums, 1, nums.length));
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
  }
}
