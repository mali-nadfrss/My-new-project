package com.mali.ds.dp.decisionMaking;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-320/problems/number-of-beautiful-partitions/ */
public class NumberofBeautifulPartitions {

  public static int beautifulPartitions(String s, int k, int minLength) {

    prime.add('2');
    prime.add('3');
    prime.add('5');
    prime.add('7');
    int[][] dp = new int[k + 1][s.length() + 1];
    int ans = recursion(s, k - 1, minLength, minLength, dp);
    return ans;
  }

  static Set<Character> prime = new HashSet<>();

  static int recursion(String s, int k, int min, int index, int[][] dp) {

    if (k == 0) {
      return 1;
    }
    if (index >= s.length()) {
      return 0;
    }

    if (dp[k][index] > 0) {
      return dp[k][index];
    }
    int ans1 = 0;
    if (!prime.contains(s.charAt(index - 1))
        && prime.contains(s.charAt(index))
        && index + min < s.length()) {
      ans1 = 1+recursion(s, k - 1, min, index + min, dp);
    }
    dp[k][index] = recursion(s, k, min, index + 1, dp) + ans1;
    return dp[k][index];
  }

  public static void main(String[] args) {
    System.out.println(beautifulPartitions("23542185131", 3, 3));
  }
}
