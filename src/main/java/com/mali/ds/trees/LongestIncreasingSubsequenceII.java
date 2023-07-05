package com.mali.ds.trees;

import java.util.Arrays;

/* https://leetcode.com/contest/weekly-contest-310/problems/longest-increasing-subsequence-ii/ */
public class LongestIncreasingSubsequenceII {
  public static final int N = 100001;

  public static int lengthOfLIS(int[] nums, int k) {

    int ans = 1;
    int[] st = new int[4 * N];
    int previous = -1;
    for (int num : nums) {
      if (previous == num) continue;
      int res = segmentSearch(st, 0, N - 1, 0, Math.max(0, num - k), num-1) + 1;
      ans = Math.max(ans, res);
      segmentInsert(st, 0, res, 0, N - 1, num);
      previous = num;
    }

    return ans;
  }

  static void segmentInsert(int[] st, int pos, int value, int low, int high, int index) {
    if (low == high && low == index) {
      st[pos] = value;
      return;
    }
    if (low >= high) return;
    int mid = (low + high) / 2;
    if(mid >= index)
    segmentInsert(st, 2 * pos + 1, value, low, mid, index);
    else segmentInsert(st, 2 * pos + 2, value, mid + 1, high, index);
    st[pos] = Math.max(st[2 * pos + 1], st[2 * pos + 2]);
  }

  static int segmentSearch(int[] st, int low, int high, int pos, int qlow, int qhigh) {

    if (qlow > high || qhigh < low) {
      return 0;
    }

    if (qlow <= low && qhigh >= high) {
      return st[pos];
    }

    int mid = (low + high) / 2;
    return Math.max(
        segmentSearch(st, low, mid, 2 * pos + 1, qlow, qhigh),
        segmentSearch(st, mid + 1, high, 2 * pos + 2, qlow, qhigh));
  }

  // doesnt work as this can be done in better time using segment tree.
  public static int lengthOfLISDP(int[] nums, int k) {

    int len = nums.length;
    int[] dp = new int[len];
    Arrays.fill(dp, 1);
    int ans = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && nums[i] - nums[j] <= k) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          ans = Math.max(dp[i], ans);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(lengthOfLIS(new int[] {7, 4, 5, 1, 8, 12, 4, 7}, 5));
  }
}
