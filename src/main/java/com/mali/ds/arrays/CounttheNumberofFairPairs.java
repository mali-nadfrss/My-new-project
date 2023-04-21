package com.mali.ds.arrays;

import java.util.Arrays;

/* https://leetcode.com/problems/count-the-number-of-fair-pairs/description/ */
public class CounttheNumberofFairPairs {

  // counting always find start and end index if they are need to come between some index
  public static long countFairPairs(int[] nums, int lower, int upper) {

    Arrays.sort(nums);
    long count = 0;
    int start = 0;
    int end = 0;
    int len = nums.length;
    for (int i = len - 1; i > start; ) {

      if (nums[start] + nums[i] <= upper) {
        count += i - start++;
      } else {
        i--;
      }
    }

    for (int i = len - 1; i > end; ) {

      if (nums[end] + nums[i] < lower) {
        count -= i - end++;
      } else {
        i--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countFairPairs(new int[] {1, 7, 9, 2, 5}, 11, 11));
  }
}
