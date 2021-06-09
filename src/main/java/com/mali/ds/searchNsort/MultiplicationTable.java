package com.mali.ds.searchNsort;
/*
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
HARD
 */
public class MultiplicationTable {

  public static int findKthNumber(int m, int n, int k) {
    int low = 1;
    int high = m * n+1;
    while (high > low) {
      int mid = low + (high - low) / 2;
      int c = count(mid, m , n);
      if (c >= k ){
        high = mid;
      } else {
        low = mid+1;
      }
    }
    return high;
  }

  private static int count(int v, int m, int n){
    int count = 0;
    for (int i = 1; i <= m; i++) {
      int temp = Math.min(v/i, n);
      count = count + temp;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(findKthNumber(3,3, 7));
  }

}
