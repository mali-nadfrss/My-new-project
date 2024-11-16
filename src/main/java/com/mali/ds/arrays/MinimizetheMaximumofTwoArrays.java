package com.mali.ds.arrays;

/* https://leetcode.com/contest/biweekly-contest-94/problems/minimize-the-maximum-of-two-arrays/*/
public class MinimizetheMaximumofTwoArrays {

  public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

    long lcm = ((long) divisor1 * divisor2) / gcd(divisor1, divisor2);

    long low = 0;
    long high = 1000000007;
    while (low < high) {

      long mid = low + (high - low) / 2;
      if (uniqueCnt1 <= mid - mid / divisor1
          && uniqueCnt2 <= mid - mid / divisor2
          && uniqueCnt1 + uniqueCnt2 <= mid - mid / lcm) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return (int) high;
  }

  static int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }

  public static void main(String[] args) {
    System.out.println(minimizeSet(2, 4, 8, 2));
    // 1,2,9 , 3456781011
  }
}
