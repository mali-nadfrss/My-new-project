package com.mali.ds.maths;

/* https://leetcode.com/contest/weekly-contest-315/problems/sum-of-number-and-its-reverse/ */
public class SumofNumberandItsReverse {
  public static boolean sumOfNumberAndReverse(int num) {

    if (num == 0) return true;
    for (int i = num / 2; i <= num; i++) {
      if (i + rev(i) == num) return true;
    }

    return false;
  }

  static int rev(int i) {
    int ans = 0;
    while (i > 0) {
      ans = ans * 10 + i % 10;
      i = i / 10;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(sumOfNumberAndReverse(63));
  }
}
