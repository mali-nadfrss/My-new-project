package com.mali.ds.dp;

import java.util.Arrays;

/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 medium
 */
public class PartitionToKEqualSumSubsets {

  public static boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) sum += num;
    if (k == 0 || sum % k != 0) return false;
    Arrays.sort(nums);
    return possible(nums, sum / k, new int[k], nums.length - 1);
  }

  public static boolean possible(int[] nums, int sum, int[] p, int idx) {
    if (idx == -1) {
      for (int s : p) if (s != sum) return false;
      return true;
    }
    int num = nums[idx];
    for (int i = 0; i < p.length; i++) {
      if (p[i] + num <= sum) {
        p[i] += num;
        if (possible(nums, sum, p, idx - 1)) {
          return true;
        }
        p[i] -= num;
      }
    }
    return false;
  }

  static boolean usingTabulation(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % k != 0) {
      return false;
    }
    sum = sum / k;

    int[][] dp = new int[nums.length + 1][sum + 1];
    for (int i = 0; i < nums.length + 1; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < nums.length + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (nums[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return k == dp[nums.length][sum];
  }

  static boolean isSumPossible(int[] nums, int sum, boolean[] isAvailable) {

    boolean[][] dp = new boolean[nums.length + 1][sum + 1];
    dp[0][0] = true;
    for (int i = 1; i <= nums.length; i++) {
      for (int j = nums[i - 1]; j <= sum; j++) {
        if (isAvailable[i - 1]) {
          continue;
        }
        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
      }
    }
    return dp[nums.length][sum];
  }

  public static void main(String[] args) {
    int[] nums = new int[] {4, 3, 2, 3, 5, 2, 1};
    System.out.println(canPartitionKSubsets(nums, 4));
    System.out.println(usingTabulation(nums, 4));
    System.out.println(isSumPossible(nums, 23, new boolean[7]));
  }
}
