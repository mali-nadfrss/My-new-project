package com.mali.ds.searchNsort;

import java.util.Arrays;

/* https://leetcode.com/contest/weekly-contest-325/problems/maximum-tastiness-of-candy-basket/ */
public class MaximumTastinessofCandyBasket {

  public static int maximumTastiness(int[] price, int k) {

    int[] diff = new int[price.length - 1];
    Arrays.sort(price);
    for (int i = 1; i < price.length; i++) {
      diff[i - 1] = price[i] - price[i - 1];
    }

    int low = 0;
    int high = diff[price.length - 2]+1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if (check(diff, mid, k)) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low-1;
  }

  static boolean check(int[] diff, int mid, int k) {
    int sum = 0;
    int count = 1;
    for (int i = 0; i < diff.length; i++) {
      sum += diff[i];
      if (sum >= mid) {
        sum = 0;
        count++;
      }
      if (count >= k) {
        return true;
      }
    }
    return count >= k;
  }

  public static void main(String[] args) {
    System.out.println(maximumTastiness(new int[] {34, 116, 83, 15, 150, 56, 69, 42, 26}, 6));
  }
}
