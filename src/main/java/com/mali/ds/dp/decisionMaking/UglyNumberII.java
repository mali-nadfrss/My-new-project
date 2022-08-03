package com.mali.ds.dp.decisionMaking;

/* https://leetcode.com/problems/ugly-number-ii/
 * medium */
public class UglyNumberII {

  public static int nthSuperUglyNumber(int n, int[] primes) {

    int[] ans = new int[n];
    ans[0] = 1;
    int[] arr = new int[primes.length];

    for (int i = 1; i < n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        if (min >= ans[arr[j]] * primes[j]) {
          min = ans[arr[j]] * primes[j];
        }
      }
      for (int j = 0; j < primes.length; j++) {
        if (min == ans[arr[j]] * primes[j]) {
          arr[j]++;
        }
      }
      ans[i] = min;
    }
    return ans[n - 1];
  }

  // idea is every possible number is min of already calculated number
  public static int nthUglyNumber(int n) {

    int i2 = 0;
    int i3 = 0;
    int i5 = 0;
    int[] ans = new int[n];
    ans[0] = 1;

    int i = 1;

    while (i < n) {
      ans[i] = Math.min(ans[i2] * 2, Math.min(ans[i3] * 3, ans[i5] * 5));
      if (ans[i] % 2 == 0) i2++;
      if (ans[i] % 3 == 0) i3++;
      if (ans[i] % 5 == 0) i5++;
      i++;
    }

    return ans[i - 1];
  }

  public static void main(String[] args) {
    System.out.println(nthUglyNumber(12));
    System.out.println(nthSuperUglyNumber(1, new int[] {2, 3,5}));
  }
}
