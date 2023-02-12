package com.mali.ds.searchNsort;

import java.util.Arrays;

/* https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/ */
public class MinimumNumberofOperationstoMakeArrayContinuous {

  public static int minOperations(int[] nums) {
    int len = nums.length;
    int ans = Integer.MAX_VALUE;
    Arrays.sort(nums);
    int start = 0;

    int[] count = new int[nums.length];
    for (int i = 1; i < len; i++) {
      if (nums[i] == nums[i - 1]) {
        count[i] = count[i - 1] + 1;
      } else {
        count[i] = count[i - 1];
      }
    }

    for (int end = 0; end < len; end++) {
      if (nums[end] - nums[start] < len) {
        ans = Math.min(ans, len - (end - start + 1) + count[end] - count[start]);
      } else {
        while (nums[end] - nums[start] >= len) {
          start++;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minOperations(new int[] {5, 4, 8, 8, 9, 9}));
  }
}
