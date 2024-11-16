package com.mali.ds.arrays;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-345/problems/find-the-losers-of-the-circular-game/ */
public class FindtheLosersoftheCircularGame {

  public static int[] circularGameLosers(int n, int k) {

    Set<Integer> set = new HashSet<>();

    set.add(1);
    int cur = 1;
    int i = 0;
    while (++i > 0) {
      int f = (cur + i * k )%n;
      cur = f == 0 ? n : f;
      if (!set.add(cur)) break;
    }
    if (n <= set.size()) return new int[] {};
    int[] ans = new int[n - set.size()];
    int j = 0;

    for (i = 1; i <= n; i++) {
      if (!set.contains(i)) {
        ans[j++] = i;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    circularGameLosers(5, 3);
  }
}
