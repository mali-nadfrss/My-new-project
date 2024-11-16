package com.mali.ds.maths;

/* https://leetcode.com/contest/weekly-contest-317/problems/minimum-addition-to-make-integer-beautiful/ */
public class MinimumAdditiontoMakeIntegerBeautiful {

  public static long makeIntegerBeautiful(long n, int target) {

    long k = 10;
    long actual = n;
    while (sum(n) > target) {
      n = n / k;
      n = (n + 1) * k;
      k = k * 10;
    }

    return n - actual;
  }

  static int sum(long n) {
    int ans = 0;
    while (n > 0) {
      ans += n % 10;
      n = n / 10;
    }
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(makeIntegerBeautiful(467, 6)); // 0
}


  }
