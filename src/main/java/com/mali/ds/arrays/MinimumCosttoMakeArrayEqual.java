package com.mali.ds.arrays;

/* https://leetcode.com/contest/weekly-contest-316/problems/minimum-cost-to-make-array-equal/ */
public class MinimumCosttoMakeArrayEqual {

  public static long minCost(int[] nums, int[] cost) {

    long ans = Long.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {

      long cur = 0;

      for (int j = 0; j < nums.length; j++) {
        cur += (long) Math.abs(nums[i] - nums[j]) * cost[j];
      }

      ans = Math.min(cur, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minCost(new int[] {1, 3, 5, 2}, new int[] {2, 3, 1, 14}));
  }
}
