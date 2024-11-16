package com.mali.ds.arrays;

import java.util.Arrays;

public class FindtheMaximumNumberofMarkedIndices {

  public static int maxNumOfMarkedIndices(int[] nums) {
    Arrays.sort(nums);
    int ans = 0;
    for (int i = 0, end = nums.length-nums.length / 2; end < nums.length; end++) {
      if (2 * nums[i] <= nums[end]) {
        i++;
        ans += 2;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    maxNumOfMarkedIndices(
        new int[] {
          42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14,
          64, 29, 15, 40
        });
  }
}
