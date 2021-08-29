package com.mali.ds.dp;
/*
https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
Hard
 */
public class FindIntegers {
  public static int findIntegers(int n) {
    int len = Integer.toBinaryString(n).length();
    int[] arr = new int[len + 1];
    arr[0] = arr[1] = 1;
    for (int i = 2; i <= len; i++) {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
    int result = 0;
    boolean prebit = false;
    for (int i = 30; i >= 0; i--) {
      if ((n & (1 << i)) != 0) {
        result = result + arr[i + 1];
        if (prebit) return result;
        prebit = true;
      } else {
        prebit = false;
      }
    }
    return result+1;
  }

  public static void main(String[] args) {
    System.out.println(findIntegers(199));
  }
}
