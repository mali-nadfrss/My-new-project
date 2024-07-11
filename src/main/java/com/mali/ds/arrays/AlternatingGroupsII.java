package com.mali.ds.arrays;

/* https://leetcode.com/problems/alternating-groups-ii/description/ */
public class AlternatingGroupsII {

  public static int numberOfAlternatingGroups(int[] c, int k) {

    int len = c.length;
    int[] dp = new int[2 * len];
    dp[0] = 1;
    int ans = 0;
    for (int i = 1; i < 2 * len; i++) {

      if (c[(i - 1) % len] != c[i % len]) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 1;
      }
      if (dp[i] >= k) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] c = {0, 1, 0, 0, 1, 0, 1};
    int k = 6;
    numberOfAlternatingGroups(c, k);
  }
}
