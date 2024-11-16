package com.mali.ds.bitManipulation;

public class MaximumXorProduct {

  public static int maximumXorProduct(long a, long b, int n) {

    int MOD = 100000007;
    for (int i = n - 1; i >= 0; i--) {
      long bit = 1 << i;
      if ((a & bit) == (b & bit)) {
        a |= bit;
        b |= bit;
      }
      if ((a & bit) == 0 || (b & bit) == 0) {
        if (a > b) {
          long temp = a;
          a = b;
          b = temp;
        }
        a |= bit;
        b &= ~bit;
      }
    }
    return (int) (a % MOD * b % MOD % MOD);
  }

  public static void main(String[] args) {

    maximumXorProduct(12, 5, 4);
  }
}
