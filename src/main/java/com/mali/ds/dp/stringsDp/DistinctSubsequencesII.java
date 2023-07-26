package com.mali.ds.dp.stringsDp;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/distinct-subsequences-ii/description/ */
public class DistinctSubsequencesII {

  public static final int M = 1000000007;

  // abac -> a ab b c ac abc
  // a -> 1 , b -> 2, a -> 1+2  c-> 1+
  public static int distinctSubseqII(String s) {

    int m = s.length();
    long[] dp = new long[26];
    long ans = 0;
    for (int i = 0; i < m; i++) {
      int k = s.charAt(i) - 'a';
      int count = 0;
      for (int j = 0; j < 26; j++) {
        count += dp[j];
        count %= M;
      }
      dp[k] =count+1;
    }
    for (int i = 0; i < 26; i++) {
      ans += dp[i];
      ans %= M;
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    distinctSubseqII("aaa");
  }
}
