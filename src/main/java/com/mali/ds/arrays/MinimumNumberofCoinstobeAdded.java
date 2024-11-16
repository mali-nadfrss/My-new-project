package com.mali.ds.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-374/problems/minimum-number-of-coins-to-be-added/
 * medium
 * */
public class MinimumNumberofCoinstobeAdded {

  public static int minimumAddedCoins(int[] coins, int target) {

    int ans = 0;

    Arrays.sort(coins);
    int len = coins.length;
    Set<Integer> sum = new HashSet<>();
    sum.add(coins[0]);
    for (int i = 1; i < len; i++) {

      Set<Integer> sum1 = new HashSet<>();
      for (int j : sum) {
        sum1.add(coins[i] + j);
      }
      sum.add(coins[i]);
      sum.addAll(sum1);
    }

    for (int i = 1; i <= target; i = i << 1) {
      if (!sum.contains(i)) {
        ans++;
        Set<Integer> sum1 = new HashSet<>();
        for (int j : sum) {
          sum1.add(i + j);
        }
        sum.add(i);
        sum.addAll(sum1);
      } else {
        for (int j = i; j < (i << 1); j++) {
          if (!sum.contains(j)) {
            ans++;
            Set<Integer> sum1 = new HashSet<>();
            for (int k : sum) {
              sum1.add(k + j);
            }
            sum.add(j);
            sum.addAll(sum1);
          }
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] coins = {1, 15, 12};
    int target = 43;

    minimumAddedCoins(coins, target);
  }
}
