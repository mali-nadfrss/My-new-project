package com.mali.ds.dp.max_min;

/*
https://leetcode.com/problems/2-keys-keyboard/
medium
 */
public class KeysKeyBoard {
  public static int minSteps(int n) {
    if (n == 1) {
      return 0;
    }
    return helper(n);
  }

  public static int helper(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return i + helper(n / i);
      }
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(minSteps(8));
  }
}
