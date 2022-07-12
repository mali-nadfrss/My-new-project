package com.mali.ds.strings;

/* https://leetcode.com/problems/minimum-time-to-make-rope-colorful/ */
public class MinimumTimetoMakeRopeColorful {
  public static int minCost(String colors, int[] neededTime) {
    int ans = 0;
    int k = 0;
    for (int i = 0; i < colors.length() - 1; i++) {
      if (colors.charAt(i) != colors.charAt(i + 1)) {
        k += 1;
      } else {
        if (neededTime[k] > neededTime[i + 1]) {
          ans += neededTime[i + 1];
          k = i + 1;
        } else {
          ans += neededTime[k];
          k = i + 1;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(minCost("aaabbbabbbb", new int[] {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
  }
}
