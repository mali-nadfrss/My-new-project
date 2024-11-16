package com.mali.ds.searchNsort;

public class MaximizetheMinimumPoweredCity {

  public static long maxPower(int[] stations, int r, int k) {

    long[] power = new long[stations.length + 1];
    long[] preFix = new long[stations.length + 1];

    for (int i = 1; i < stations.length + 1; i++) {
      preFix[i] = preFix[i - 1] + stations[i - 1];
    }

    for (int i = 0; i <= stations.length; i++) {
      int lb = Math.max(0, i - r - 1);
      int hb = Math.min(stations.length, i + r);
      power[i] = preFix[hb] - preFix[lb];
    }

    long low = 0;
    long high = preFix[preFix.length - 1] + k;
    while (low < high) {

      long mid = low + (high - low) / 2;
      if (isPossible(k, r, mid, power)) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    return low - 1;
  }

  static boolean isPossible(int k, int r, long mid, long[] power) {
    long[] extra = new long[power.length + 1];
    for (int i = 1; i < power.length; i++) {
      extra[i] = extra[i-1] + extra[i];
      long needed = 0;
      if (power[i] + extra[i] < mid) {
        needed = mid - power[i]-extra[i];
        extra[i] += needed;
        k -= needed;
        if (i + r+1 < power.length) extra[i + r+1] = -needed;
      }
      if (k < 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    System.out.println(maxPower(new int[] {1, 2, 4, 5, 0}, 1, 2));
  }
}
