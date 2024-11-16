package com.mali.ds.searchNsort;

import java.util.Arrays;

/* https://leetcode.com/problems/find-k-th-smallest-pair-distance/solutions/?orderBy=most_votes */
public class FindKthSmallestPairDistance {

  public static int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int len = nums.length;
    int min = Integer.MAX_VALUE;
    int max = nums[len - 1] - nums[0];
    for (int i = 1; i < len; i++) {
      min = Math.min(min, nums[i] - nums[i - 1]);
    }
    int mid = min + (max - min) / 2;
    while (min < max) {
      mid = min + (max - min) / 2;
      if (count(mid, nums) < k) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return mid;
  }

  static int count(int val, int[] nums) {
    int cnt = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int min = i;
      int max = len - 1;
      while (min < max) {
        int mid = min + max - min / 2;
        if (mid < len && nums[mid] <= val) {
          min = mid + 1;
        } else {
          max = mid;
        }
      }
      cnt += min - i - 1;
    }
    return cnt;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 1};
    int k = 1;
    System.out.println(smallestDistancePair(nums, k));
  }
}
