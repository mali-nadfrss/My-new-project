package com.mali.problemSolving;

// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/?ref=lbp
public class ShareProfit {

  static int calProfit(int[] p) {
    int ans = 0;
    int l = p.length;
    int[] a = new int[l];
    int maxPrice = p[l - 1];
    for (int i = l - 1; i >= 0; i--) {
      if (maxPrice <= p[i]) {
        maxPrice = p[i];
      }
      ans = Math.max(ans, maxPrice - p[i]);
      a[i] = ans;
    }

    int minPrice = p[0];

    for (int i = 0; i < l; i++) {
      if (minPrice > p[i]) {
        minPrice = p[i];
      }
      ans = Math.max(ans, a[i] + p[i] - minPrice);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] p = {2, 30, 15, 10, 8, 25, 80};
    System.out.println(calProfit(p));
  }
}
