package com.mali.ds.arrays;

import com.mali.util.BracesConversion;

import java.util.Arrays;

/* https://leetcode.com/problems/maximum-points-after-enemy-battles/description/ */
public class MaximumPointsAfterEnemyBattles {

  public static long maximumPoints(int[] e, int c) {

    Arrays.sort(e);
    int marked = e.length-1;
    if (c < e[0]) {
      return 0;
    }
    long ans = 0;
    while (marked >= 0) {
      if (c >= e[0]) {
        ans += c / e[0];
        c = c % e[0];
      }
      c += e[marked--];
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {3, 2, 2};
    maximumPoints(arr, 2);
  }
}
