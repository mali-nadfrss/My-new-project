package com.mali.ds.bitManipulation;

/* https://leetcode.com/contest/biweekly-contest-104/problems/maximum-or/ */
public class MaximumOR {

  public static long maximumOr(int[] nums, int k) {
    int[] right = new int[nums.length];
    for (int i = nums.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] | nums[i+1];
    }
    long ans = 0;
    long left = 0;
    for (int i = 0; i < nums.length; i++) {
      ans = Math.max(ans, left | right[i] | nums[i] << k);
      left |= nums[i];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {
      8, 1,2
    };
    int k = 2;
    maximumOr(nums, k);
  }
}
