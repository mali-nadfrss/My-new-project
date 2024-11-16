package com.mali.ds.strings;

/* https://leetcode.com/contest/weekly-contest-319/problems/maximum-number-of-non-overlapping-palindrome-substrings/*/
public class MaximumNumberofNonoverlappingPalindromeSubstrings {

  public int maxPalindromes(String s, int k) {

    int[] dp = new int[s.length() + 1];
    return recursion(s, 0, k, dp);
  }

  int recursion(String s, int index, int k, int[] dp) {

    if (index + k > s.length()) return 0;
    if (dp[index] > 0) return dp[index];
    int ans = 0;
    if (isPalin(s, index, index + k - 1)) {
      ans = 1 + recursion(s, index + k, k, dp);
    }
    ans = Math.max(recursion(s, index + 1, k, dp), ans);
    dp[index] = Math.max(ans, recursion(s,index, k+1, dp) );
    return dp[index];
  }

  boolean isPalin(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    MaximumNumberofNonoverlappingPalindromeSubstrings r =
        new MaximumNumberofNonoverlappingPalindromeSubstrings();
    System.out.println(r.maxPalindromes("abaccdbbd", 3));
  }
}
