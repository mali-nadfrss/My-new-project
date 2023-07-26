package com.mali.ds.dp.stringsDp;

/* https://leetcode.com/problems/longest-common-subsequence/
 * medium
 * important
 * */
public class LongestCommonSubsequence {

  public static int longestCommonSubsequenceBottom(String text1, String text2) {

    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[text1.length()][text2.length()];
  }

  public static int longestCommonSubsequence(String text1, String text2) {
    return recursion(text1, text2, 0, 0, new Integer[text1.length() + 1][text2.length() + 1]);
  }

  private static int recursion(String t1, String t2, int i, int j, Integer[][] dp) {
    if (i >= t1.length() || j >= t2.length()) {
      return 0;
    }
    if (dp[i][j] != null) {
      return dp[i][j];
    }
    if (t1.charAt(i) == t2.charAt(j)) {
      dp[i][j] = 1 + recursion(t1, t2, i + 1, j + 1, dp);
    } else {
      dp[i][j] = Math.max(recursion(t1, t2, i + 1, j, dp), recursion(t1, t2, i, j + 1, dp));
    }
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubsequenceBottom("ezupkr", "ubmrapg"));
  }
}
