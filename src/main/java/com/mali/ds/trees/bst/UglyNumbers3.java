package com.mali.ds.trees.bst;

/*
https://leetcode.com/problems/ugly-number-iii/
Medium
 */
public class UglyNumbers3 {
  public static int nthUglyNumber(int n, int a, int b, int c) {
    long min = Math.min(a, Math.min(b, c));
    long max = Integer.MAX_VALUE;
    long result = 0;
    while (max > min) {
      long mid = min + (max - min) / 2;
      long temp = func(a, b, c, mid);
      if (temp >= n) {
        result = mid;
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    return (int) result;
  }

  static long func(long a, long b, long c, long mid) {
    return mid / a
        + mid / b
        + mid / c
        - mid / lcm(a, b)
        - mid / lcm(b, c)
        - mid / lcm(c, a)
        + mid / lcm(a, lcm(b, c));
  }

  static long gcd(long a, long b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }

  static long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }

  public static void main(String[] args) {
    int[] nums = {62,100,4};
    System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
  }

}
