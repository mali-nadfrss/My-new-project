package com.mali.ds.searchNsort;

/*
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
medium
 */
public class ShipPackages {
  public static int shipWithinDays(int[] weights, int days) {
    int total = 0;
    int max = 0;
    for (int i = 0; i < weights.length; i++) {
      if (max < weights[i]) {
        max = weights[i];
      }
      total = total + weights[i];
    }
    while (max < total) {
      int mid = max + (total - max) / 2;
      if (cal(weights, mid, days)) {
        total = mid;
      } else {
        max = mid + 1;
      }
    }
    return max;
  }

  static boolean cal(int[] weights, int capacity, int days) {
    int total = 0;
    int actualDays = 1;
    for (int weight : weights) {
      total = total + weight;
      if (total > capacity) {
        total = weight;
        actualDays = actualDays + 1;
      }
    }
    return actualDays <= days;
  }

  public static void main(String[] args) {
    int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(shipWithinDays(weights, 5));
  }
}
