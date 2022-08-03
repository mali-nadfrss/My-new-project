package com.mali.ds.dp.stringsDp;

/*
 * https://leetcode.com/problems/distinct-subsequences/
 * Hard
 * */
public class DistinctSusbsequences {

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
    dp[i][j]= ans + recursion(s, t, i + 1, j, dp);
    return dp[i][j];
  }

  public static void main(String[] args) {
    System.out.println(numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc"
            ,"bcddceeeebecbc"));
  }
}
