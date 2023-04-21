package com.mali.ds.searchNsort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/ */
public class MinimizeTheMaximumDifferenceofPairs {

  public static int minimizeMax(int[] nums, int p) {

    Arrays.sort(nums);
    int max = nums[nums.length - 1] - nums[0];
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i] - nums[i - 1]);
    }

    while (min < max) {

      int mid = min + (max - min) / 2;
      if (binarySearch(nums, mid) >= p) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    return max;
  }

  static int binarySearch(int[] nums, int diff) {

    int cnt = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] <= diff && !set.contains(i) && !set.contains(i - 1)) {
        cnt++;
        set.add(i);
        set.add(i - 1);
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, 2, 3, 2, 1, 2};

    System.out.println(minimizeMax(nums, 3));
  }
}
