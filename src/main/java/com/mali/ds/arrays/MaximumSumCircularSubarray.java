package com.mali.ds.arrays;

/* https://leetcode.com/problems/maximum-sum-circular-subarray/ */
public class MaximumSumCircularSubarray {

  public static int maxSubarraySumCircular(int[] nums) {

    int sum = nums[0];
    int minSum = nums[0];
    int maxSum = nums[0];

    int minSumAns = nums[0];
    int maxSumAns = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxSumAns = Math.max(maxSum, maxSumAns);
      minSumAns = Math.min(minSum, minSumAns);
      if (minSum > 0) {
        minSum = 0;
      }
      if (maxSum < 0) {
        maxSum = 0;
      }
      int num = nums[i];
      sum += num;
      maxSum += num;
      minSum += num;
    }
    maxSumAns = Math.max(maxSum, maxSumAns);
    minSumAns = Math.min(minSum, minSumAns);
    if (sum == minSumAns) return maxSumAns;
    return Math.max(maxSumAns, sum - minSumAns);
  }

  public static void main(String[] args) {
    int A[] = {-3,-2,-3};
    System.out.println(maxSubarraySumCircular(A));
  }
}
