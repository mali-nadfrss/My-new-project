package com.mali.ds.trees.bst;

/*https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/description/
 * hard */
public class KthSmallestAmountWithSingleDenominationCombination {

  static int gcd(int c1, int c2) {
    if (c2 == 0) return c1;
    return gcd(c2, c1 % c2);
  }

  static int lcm(int c1, int c2) {
    return (c1 * c2) / gcd(c1, c2);
  }

  public static long findKthSmallest(int[] coins, int k) {
    long min = 0l;
    long max = Long.MAX_VALUE;
    long mid;
    while (min < max) {
      mid = min + (max - min) / 2;
      long count = 0;
      for (int i = 1; i < 1 << coins.length; i++) {
        int c = 0;
        int lcm = 1;
        for (int j = 0; j < coins.length; j++) {
          if ((i & (1 << j)) != 0) {
            c++;
            lcm = lcm(lcm, coins[j]);
          }
        }
        if (c > 0 && c % 2 == 0) {
          count -= mid / lcm;
        } else if(c > 0 ){
          count += mid / lcm;
        }
      }
      if (k > count) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[] coins = {5,2};
    System.out.println(findKthSmallest(coins, 7));
  }
}
