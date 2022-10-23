package com.mali.ds.arrays;

import java.util.Arrays;

/* https://leetcode.com/contest/weekly-contest-308/problems/longest-subsequence-with-limited-sum/ */
public class LongestSubsequenceWithLimitedSum {
  public static int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int[] ans = new int[queries.length];
    int sum = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < queries.length; i++) {
      sum = 0;
      boolean f = false;
      for (j = 0; j < nums.length; j++) {
        sum += nums[j];
        if (queries[i] < sum) {
          ans[i] = j;
          f = true;
          break;
        }
      }
      if (!f){
        ans[i] = nums.length;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    System.out.println(answerQueries(new int[] {4, 5, 2, 1}, new int[] {3, 10, 21}));
  }
}
