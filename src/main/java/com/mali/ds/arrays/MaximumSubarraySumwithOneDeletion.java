package com.mali.ds.arrays;

/* https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/ */
public class MaximumSubarraySumwithOneDeletion {

  public static int maximumSum(int[] arr) {

    int len = arr.length;
    int ans = arr[0];
    int od = arr[0];
    int nd = arr[0];

    for (int i = 1; i < len; i++) {
      od = Math.max(nd, od+arr[i]);
      nd = Math.max(nd+arr[i], arr[i]);
      ans = Math.max(ans, Math.max(od, nd));

    }
    return ans;
  }

  public static void main(String[] args) {
    int A[] = {11, -10, -11, 8, 7, -6, 9, 4, 11, 6, 5, 0};
    System.out.println(maximumSum(A));
  }
}
