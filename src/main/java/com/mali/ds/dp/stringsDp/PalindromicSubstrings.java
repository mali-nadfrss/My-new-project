package com.mali.ds.dp.stringsDp;

/*
https://leetcode.com/problems/palindromic-substrings/
medium
* */
public class PalindromicSubstrings {

  public static int countSubstrings(String s) {
    int ans = 0;
    Integer[][] dp = new Integer[s.length() + 1][s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        ans = ans + recursion(s, i, j, dp);
      }
    }
    return ans;
  }

  private static int recursion(String s, int start, int end, Integer[][] dp) {
    if (start > end) return 0;
    if (start == end || (end - start == 1 && s.charAt(start) == s.charAt(end))) return 1;
    if (s.charAt(start) != s.charAt(end)) return 0;
    if (dp[start][end] != null) return dp[start][end];
    dp[start][end] = recursion(s, start + 1, end - 1, dp);
    return dp[start][end];
  }

  public static void main(String[] args) {
    String[] s = {"abc", "abcbdc", "abcabc", "abccba", "kgjgkdjgkj"};
    for (String a : s) {
      System.out.println(countSubstrings(a));
    }
  }
}
