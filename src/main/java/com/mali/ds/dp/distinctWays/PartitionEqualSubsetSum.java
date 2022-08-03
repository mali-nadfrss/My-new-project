package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * medium
 * */
public class PartitionEqualSubsetSum {

  public static boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum = sum + num;
    }
    if (sum % 2 == 0) {
      return recursion(nums, sum / 2, new Boolean[sum / 2 + 1], 0);
    }
    return false;
  }

  static boolean recursion(int[] nums, int target, Boolean[] dp, int i) {
    if (target == 0) return true;
    if (target < 0) return false;
    if (dp[target] != null) return dp[target];
    while (i < nums.length) {
      boolean b = recursion(nums, target - nums[i], dp, ++i) || recursion(nums, target, dp, ++i);
      dp[target] = b;
      if (dp[target]) return true;
    }
    return false;
  }

  static boolean kanpsack(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 > 0) return false;
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int i = 0; i < nums.length; i++) {
      for (int j = sum; j >= nums[i]; j--) {
        dp[j] = dp[j] || dp[j - nums[i]];
      }
    }
    return dp[sum];
  }

  public static void main(String[] args) {
    int A[] = {3, 3, 3, 4, 5};
    System.out.println(canPartition(A));
    System.out.println(kanpsack(A));
  }
}
