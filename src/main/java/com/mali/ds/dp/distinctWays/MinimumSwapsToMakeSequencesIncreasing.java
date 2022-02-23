package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 * Hard
 * */

public class MinimumSwapsToMakeSequencesIncreasing {

  // same idea again, u can either swap a number or leave it,
  // but make sure increasing condition is satisfied always.
  public static int minSwap(int[] nums1, int[] nums2) {
    return recursion(nums1, nums2, -1, -1, 0, new Integer[nums1.length][2], 0);
  }

  static int recursion(
      int[] nums1, int[] nums2, int prevA, int prevB, int i, Integer[][] dp, int swapped) {
    // base condition, just verify if length satisfies
    // we know there is an answer for sure so dont bother about other corner cases
    if (i >= nums1.length) {
      return 0;
    }
    if (dp[i][swapped] != null) return dp[i][swapped];

    // don't swap condition, verify increasing sequence
    int ans1 = Integer.MAX_VALUE;
    if (nums1[i] > prevA && nums2[i] > prevB) {
      ans1 = recursion(nums1, nums2, nums1[i], nums2[i], i+1, dp, 0);
    }

    // swap condition: swap only if its possible
    if (nums1[i] > prevB && nums2[i] > prevA) {
      ans1 = Integer.min(ans1, 1 + recursion(nums1, nums2, nums2[i], nums1[i], i+1, dp, 1));
    }
    dp[i][swapped] = ans1;

    return dp[i][swapped];
  }

  public static void main(String[] args) {
    int[] nums1 = {0,3,5,8,9};
    int[] nums2 = {2,1,4,6,9};

    System.out.println(minSwap(nums1, nums2));
  }
}
