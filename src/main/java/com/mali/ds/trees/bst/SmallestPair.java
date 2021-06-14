package com.mali.ds.trees.bst;

import java.util.Arrays;
/*
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
HARD
 */
public class SmallestPair {

  public static int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int len = nums.length;
    int high = nums[len - 1] - nums[0];
    int low = 0;
    while (high > low) {
      int mid = low + (high - low) / 2;
      if (findPairs(nums, mid) < k) {
        low = mid+1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  public static int findPairs(int[] nums, int mid) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i+1 ;
      while (j < nums.length && nums[j] - nums[i] < mid) {
        j++;
      }
      res = res+ j-i-1;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {62,100,4};
    System.out.println(smallestDistancePair(nums, 2));
  }
}
