package com.mali.ds.dp.stringsDp;

/* https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/ */
public class MinimumASCIIDeleteSum {

  public static int minimumDeleteSum(String s1, String s2) {
    /*int ans = 0;
    for (int i = 0; i < s1.length(); i++) {
      String a = String.valueOf(s1.charAt(i));
      if (!s2.contains(a)) {
        ans = ans + s1.charAt(i);
        s1 = s1.substring(0, i) + s1.substring(i + 1);
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      String a = String.valueOf(s2.charAt(i));
      if (!s1.contains(a)) {
        ans = ans + s2.charAt(i);
        s2 = s2.substring(0, i) + s2.substring(i + 1);
      }
    }*/
    return /*ans +*/ recursion(0, 0, s1, s2, new int[s1.length()][s2.length()]);
  }

  static int recursion(int i, int j, String s1, String s2, int[][] dp) {
    if (s1 == s2) {
      return 0;
    } else if (i == s1.length()) {
      return countAll(s2, j);
    } else if (j == s2.length()) {
      return countAll(s1, i);
    } else if (dp[i][j] != 0 ){
      return dp[i][j];
    }
    else if (s1.charAt(i) == s2.charAt(j)) {
      return recursion(i + 1, j + 1, s1, s2,dp);
    } else {
      dp[i][j] = Integer.min(
          s1.charAt(i) + recursion(i + 1, j, s1, s2, dp), s2.charAt(j) + recursion(i, j + 1, s1, s2, dp));
    }
    return dp[i][j];
  }

  static int countAll(String s, int i) {
    int ans = 0;
    for (; i < s.length(); i++) {
      ans = ans + s.charAt(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minimumDeleteSum("delete", "leet"));
  }
}
