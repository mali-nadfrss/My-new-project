package com.mali.ds.arrays;

/* https://leetcode.com/contest/biweekly-contest-89/problems/minimize-maximum-of-array/ */
public class MinimizetheMaximumofTwoArray {

  // even if we decrease the number any times whole array sumwill be same
  // so just take the average of prefix and find the max till that point
  public static int minimizeArrayValue(int[] nums) {

    int sum = 0;
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // we are doing sum+i so that int division round-off can be avoided
      ans = Math.max((sum + i) / (i + 1), ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minimizeArrayValue(new int[] {3, 7, 1, 6}));
  }
}
