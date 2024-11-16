package com.mali.ds.dp.stringsDp;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/distinct-subsequences/
 * Hard
 * */
public class DistinctSusbsequences {

  // top down approach
  public static int numDistinctDP(String s, String t) {

    int m = s.length();
    int n = t.length();
    int[][] dp = new int[n + 1][m + 1];
    Arrays.fill(dp[0], 1);
    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= m; j++) {

        if (s.charAt(j - 1) == t.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    return dp[n][m];
  }

  public static int numDistinct(String s, String t) {
    return recursion(s, t, 0, 0, new Integer[s.length() + 1][t.length() + 1]);
  }

  private static int recursion(String s, String t, int i, int j, Integer[][] dp) {

    if (s.equals("") || t.equals("")) {
      return 0;
    }
    if (j == t.length()) return 1;
    if (i >= s.length()) {
      return 0;
    }
    if (dp[i][j] != null) return dp[i][j];
    int ans = 0;
    if (s.charAt(i) == t.charAt(j)) {
      ans = recursion(s, t, i + 1, j + 1, dp);
    }
    dp[i][j] = ans + recursion(s, t, i + 1, j, dp);
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(
        numDistinct(
            "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
            "bcddceeeebecbc"));

    numDistinctDP("rabbbit", "rabbit");
  }
}
