package com.mali.ds.dp.max_min;

/* https://leetcode.com/problems/wiggle-subsequence/
 * Medium
 * */
public class WiggleSubsequence {
  public static int wiggleMaxLength(int[] nums) {
    if (nums.length == 1) return 1;
      return 1
          + Math.max(
              recursion(nums, 1,0, 1, new int[nums.length][2]),
              recursion(nums, 0, 0, 1, new int[nums.length][2]));
  }

  private static int recursion(int[] nums, int order, int prev, int current, int[][] dp) {
    if (current >= nums.length || prev >= nums.length) return 0;
    if (dp[current][order] > 0) return dp[current][order];
    // increasing
    if (order == 1) {
      if (nums[current] < nums[prev]) {
        dp[current][order] =
                1 + recursion(nums, 0, current, current + 1, dp);
      } else {
        dp[current][order] = recursion(nums, order, current, current + 1, dp);
      }
    } else {
      if (nums[current] > nums[prev]) {
        dp[current][order] =
                1 + recursion(nums, 1, current, current + 1, dp);
      } else {
        dp[current][order] = recursion(nums, order, current, current + 1, dp);
      }
    }
    return dp[current][order];
  }

  public static int wiggleMaxLength_new(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    // max of taking the next one as increasing or decreasing + 1
    return 1 + Math.max(recurseHelper(nums, 1, 0, true), recurseHelper(nums, 1, 0, false));
  }

  public static int recurseHelper(int[] nums, int current, int prev, boolean positive) {
    if (current < 0 || current >= nums.length || prev < 0 || prev >= nums.length) {
      return 0;
    }
    // if the diff between prev and current should be positive,
    if (positive) {
      // yes, it is positive, increment and change it to negative
      if (nums[prev] > nums[current]) {
        return 1 + recurseHelper(nums, current + 1, current, !positive);
      } else {
        // its not positive. try the next element
        return recurseHelper(nums, current + 1, current, positive);
      }
    } else {
      // if the diff between prev and current should be negative,
      if (nums[prev] < nums[current]) {  // yes, it is negative, increment and change it to positive
        return 1 + recurseHelper(nums, current + 1, current, !positive);
      } else {
        // its not negative. try the next element
        return recurseHelper(nums, current + 1, current, positive);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(
        wiggleMaxLength(
            new int[] {
              33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95,
              51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27,
              98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40,
              32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84,
              82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15
            }));
  }
}
