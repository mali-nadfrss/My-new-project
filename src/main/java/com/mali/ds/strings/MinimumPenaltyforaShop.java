package com.mali.ds.strings;

/* https://leetcode.com/contest/biweekly-contest-92/problems/minimum-penalty-for-a-shop/ */
public class MinimumPenaltyforaShop {

  public static int bestClosingTime(String s) {

    int len = s.length();
    int[] ns = new int[len + 1];
    int[] ys = new int[len + 1];
    int y = 0;
    int n = 0;
    int i = 0;
    for (; i < len; i++) {

      ns[i] = n;
      if (s.charAt(i) == 'N') {
        n += 1;
      }
      if (s.charAt(len - i - 1) == 'Y') {
        y += 1;
      }
      ys[len - i - 1] = y;
    }

    ns[i] = n;
    i = 0;
    int ans = 0;
    int val = Integer.MAX_VALUE;
    for (; i < len + 1; i++) {
      if (ns[i] + ys[i] < val) {
        val = ns[i] + ys[i];
        ans = i;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    bestClosingTime("YNYY");
  }
}
