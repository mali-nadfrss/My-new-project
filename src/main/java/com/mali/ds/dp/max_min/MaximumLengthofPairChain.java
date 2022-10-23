package com.mali.ds.dp.max_min;

import java.util.Arrays;

/* https://leetcode.com/problems/maximum-length-of-pair-chain/ */
public class MaximumLengthofPairChain {

  public static int findLongestChain(int[][] pairs) {

    Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
    return dp(1, pairs, 1, 0, new int[pairs.length]);
  }

  static int ans = 1;

  static int dp(int cur, int[][] pairs, int count, int prev, int[] dp) {

    if (cur >= pairs.length) {
      ans = Math.max(ans, count);
      return 1;
    }

    if (dp[cur] > 0) {
      return dp[cur];
    }

    if (pairs[prev][1] < pairs[cur][0]) {
      return dp[cur] =
          Math.max(dp(cur + 1, pairs, count + 1, cur, dp) + 1, dp(cur + 1, pairs, count, prev, dp));
    } else {
      return dp[cur] =
      Math.max(dp(cur + 1, pairs, count, cur, dp) + 1, dp(cur + 1, pairs, count, prev, dp));
    }
  }

  public static void main(String[] args) {

    System.out.println(
        findLongestChain(new int[][] {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}}));
  }
}
