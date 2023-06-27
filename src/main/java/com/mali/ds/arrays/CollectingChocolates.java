package com.mali.ds.arrays;

import java.util.Arrays;

/* https://leetcode.com/contest/weekly-contest-349/problems/collecting-chocolates/*/
public class CollectingChocolates {

  public static long minCost(int[] nums, int x) {

    int len = nums.length;
    long[] vals = new long[len];
    int[] min = new int[len];
    Arrays.fill(min, Integer.MAX_VALUE);
    for (int i = 0; i < len; i++) {
      vals[i] = (long) i * x;
      for (int j = 0; j < len; j++) {
        min[j] = Math.min(min[j], nums[(j-i+len)%len]);
        vals[i] += min[j];
      }
    }

    long ans = vals[0];
    for (int i = 0; i < len; i++) {
      ans = Math.min(vals[i], ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {15, 150, 56, 69, 214, 203};
    int x = 42;
    minCost(nums, x);
  }
}
