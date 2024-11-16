package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * Medium
 * */
public class NumberOfLongestIncreasingSubsequence {

 static class Pair {
    int len;
    int count;

    Pair(int len, int count) {
      this.len = len;
      this.count = count;
    }
  }

  // use dp .. 2 for loops standard LIS solution
  public static int findNumberOfLIS(int[] nums) {
    Pair[] dp = new Pair[nums.length];
    dp[nums.length-1] = new Pair(1,1);

    for (int i = nums.length-2; i >= 0 ; i--) {
      dp[i] = new Pair(0,0);
      for (int j = i+1; j < nums.length; j++) {
        if (nums[i] < nums[j] && dp[i].len < dp[j].len+1){
          dp[i].len =   dp[j].len+1;
          dp[i].count = dp[j].count;
        } else if (nums[i] < nums[j] && dp[i].len == dp[j].len+1){
          dp[i].count += dp[j].count;
        } else{
          dp[i].len = 1;
          dp[i].count = 1;
        }
      }
    }
    return 0;
  }

  // we have 2 choices either to count the number or ignore it.
  /* static void recursion(int[] nums, int i, int curMax, int[][] count, int ans) {
    if (i >= nums.length) {
      return;
    }

    // copy values from prev value
    count[i] = count[i - 1];

    // count the number if its valid
    if (curMax < nums[i]) {
      if (count[i][0] == ans) {
        count[i][1]++;
      } else if (count[i][0] < ans) {
        count[i][0] = count[i-1][0]+1;
        count[i][1] = 1;
      }
      recursion(nums, i + 1, nums[i], count, ans + 1);
    }

    // ignore the number
    recursion(nums, i + 1, curMax, count, ans);
    recursion(nums, i + 1, nums[i], count, 1);
  }*/
  // using binary search
  public static int findNumberOfLISII(int[] arr) {
    int len = arr.length;

    for (int i = 1; i < len; i++) {
      int start = 0;
      int end = i;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (arr[mid] < arr[end]) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      arr[end] = arr[i];
    }

    int ans = 1;

    for (int i = 1; i < len; i++) {
      if (arr[i] > arr[i - 1]) {
        ans++;
      } else {
        break;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    System.out.println(findNumberOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    System.out.println(
        findNumberOfLISII(
            new int[] {
              2, 2, 2, 2, 2,
            }));
  }
}
