package com.mali.ds.dp.distinctWays;

/* https://leetcode.com/contest/biweekly-contest-91/problems/count-ways-to-build-good-strings/ */
public class CountWaysToBuildGoodStrings {

  public static int countGoodStrings(int low, int high, int zero, int one) {

    z = "";
    o = "";
    while (z.length() < zero) {
      z = z + '0';
    }
    while (o.length() < one) {
      o = o + '1';
    }
    recursion(low, high, z);
    recursion(low, high, o);
    return ans;
  }

  static String z;
  static String o;
  static int ans = 0;

  static void recursion(int low, int high, String s) {

    if (s.length() > high) {
      return;
    }
    if (s.length() >= low) {
      ans++;
    }

    recursion(low, high, s + z);
    recursion(low, high, s + o);
  }

  public static void main(String[] args) {

    System.out.println(countGoodStrings(20,20,1,2));
  }
}
