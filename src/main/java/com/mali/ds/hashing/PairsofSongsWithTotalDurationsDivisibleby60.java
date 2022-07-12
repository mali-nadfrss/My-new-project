package com.mali.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * medium */
public class PairsofSongsWithTotalDurationsDivisibleby60 {

  public static int numPairsDivisibleBy60(int[] time) {

    int ans = 0;
    int[] c = new int[61];
    for (int i : time) {
      ans = ans + c[(600 - i) % 60];
      c[i % 60] += 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(numPairsDivisibleBy60(new int[] {60, 60, 60}));
  }
}
