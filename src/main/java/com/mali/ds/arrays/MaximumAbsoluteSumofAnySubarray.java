package com.mali.ds.arrays;

/* https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 * medium */
public class MaximumAbsoluteSumofAnySubarray {
  public static int maxAbsoluteSum(int[] nums) {
    int ans = 0;
    int min_sum = 0;
    int max_sum = 0;
    for (int i : nums) {
      if (min_sum + i < 0) {
        min_sum += i;
      } else {
        min_sum = 0;
      }
      if (max_sum + i > 0) {
        max_sum += i;
      } else {
        max_sum = 0;
      }
      ans = Math.max(ans, Math.max(min_sum * -1, max_sum));
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {
      -25, 38, 24, -17, 7, 31, 43, 8, 20, 49, -33, -11, 19, 13, -28, 44, 23, -3, -19, 12, 32, 40,
      42, 41, 7, -35, -29, 7, 24, 41, -3, 1, -19, -29, -13, -10, 4, -20, 48
    };
    System.out.println(maxAbsoluteSum(new int[] {1, -3, 2, 3, -4}));
    System.out.println(maxAbsoluteSum(arr));
  }
}
