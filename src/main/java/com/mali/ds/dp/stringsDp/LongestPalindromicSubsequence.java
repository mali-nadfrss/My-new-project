package com.mali.ds.dp.stringsDp;

/* https://leetcode.com/problems/longest-palindromic-subsequence/
 * medium
 * important
 *  */
public class LongestPalindromicSubsequence {

  /* Note subsequence is : aaba --> aaa
  check if first and last characters are equal
  * yes : check if substring of middle other characters
  * No : ignore first character and check or ignore last character and check
  * */
  public static int longestPalindromeSubseq(String s) {
    return recursion(0, s.length() - 1, s, new int[s.length() + 1][s.length() + 1]);
  }

  private static int recursion(int left, int right, String s, int[][] dp) {
    if (left > right) return 0;
    if (left == right) return 1;
    if (dp[left][right] > 0) return dp[left][right];
    if (s.charAt(left) == s.charAt(right)) {
      dp[left][right] = 2 + recursion(left + 1, right - 1, s, dp);
    } else {
      dp[left][right] =
          Math.max(recursion(left, right - 1, s, dp), recursion(left + 1, right, s, dp));
    }
    return dp[left][right];
  }

  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("akjdckkkj"));
  }
}
