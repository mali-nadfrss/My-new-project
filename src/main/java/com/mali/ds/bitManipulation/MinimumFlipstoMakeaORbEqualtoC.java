package com.mali.ds.bitManipulation;

/* https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * medium */
public class MinimumFlipstoMakeaORbEqualtoC {
  public static int minFlips(int a, int b, int c) {
    int ans = 1;
    int ans1 = 0;
    int ans2 = 0;
    int ans3 = 0;
    int count = 0;
    while (a > 0 || b > 0 || c > 0) {
      ans1 = a & ans;
      ans2 = b & ans;
      ans3 = c & ans;
      if (ans1 == 1 && ans2 == 1 && ans3 == 0) {
        count += 2;
      } else if ((ans1 == 1 || ans2 == 1) && ans3 == 0) {
        count += 1;
      } else if (ans1 == 0 && ans2 == 0 && ans3 == 1) {
        count += 1;
      }
      a = a >> 1;
      b = b >> 1;
      c = c >> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minFlips(4, 2, 7));
  }
}
