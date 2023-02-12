package com.mali.ds.searchNsort;

/* https://leetcode.com/contest/weekly-contest-331/problems/house-robber-iv/ */
public class HouseRobberIV {

  // naive way
  public static int minCapability(int[] nums, int k) {
    recursion(nums, 0, k, 0);
    return ans;
  }

  static int ans = Integer.MAX_VALUE;

  static void recursion(int[] nums, int index, int k, int max) {

    if (k == 0) {
      ans = Math.min(ans, max);
      return;
    }

    if (index >= nums.length) {
      return;
    }

    // select case
    recursion(nums, index + 2, k - 1, Math.max(nums[index], max));

    // dont select
    recursion(nums, index + 1, k, max);
  }

  //maxi min problem always go for binary search
  public static int minCapabilityBinary(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int len = nums.length;
    for (int num : nums) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    while (min < max) {
      int mid = min + (max - min) / 2;
      int take = 0;
      for (int j = 0; j < len; j++) {
        if (nums[j] <= mid) {
          take++;
          j++;
        }
      }
      if (take >= k) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }

    return min;
  }

  public static void main(String[] args) {

    int[] nums = {7, 3, 9, 5};
    int k = 2;
    System.out.println(minCapabilityBinary(nums, k));
  }
}
