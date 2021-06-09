package com.mali.ds.searchNsort;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
medium
 */
public class BloomDay {

  public static boolean isBloomed(int[] bloomDay, int m, int k, int mid) {
    int kTemp = 0;
    int mTemp = 0;
    for (int j = 0; j < bloomDay.length; j++) {
      //
      if (bloomDay[j] > mid) {
        kTemp = 0;
        continue;
      }
      kTemp++;
      if (kTemp == k) {
        mTemp = mTemp + 1;
        kTemp = 0;
      }
      if (mTemp >= m) {
        return true;
      }
    }
    if (kTemp == k) {
      mTemp = mTemp + 1;
    }
    return mTemp >= m;
  }
  /*
  with binary search
   */
  public static int minDays(int[] bloomDay, int m, int k) {
    if (m * k > bloomDay.length) {
      return -1;
    }
    int ans = Integer.MAX_VALUE;

    int max = Arrays.stream(bloomDay).max().getAsInt();
    int min = 0;

    while (min <= max) {
      int mid = min + (max - min) / 2;
      if (isBloomed(bloomDay, m, k, mid)) {
        ans = Math.min(mid, ans);
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  /*
  normal logic
   */
  public static int minDaysMyOwn(int[] bloomDay, int m, int k) {
    if (m * k > bloomDay.length) {
      return -1;
    }
    int[] temp = Arrays.copyOf(bloomDay, bloomDay.length);
    Arrays.sort(temp);
    for (int i = 0; i < temp.length; i++) {
      //
      int kTemp = 0;
      int mTemp = 0;
      for (int j = 0; j < bloomDay.length; j++) {
        //
        if (bloomDay[j] > temp[i]) {
          kTemp = 0;
          continue;
        }
        kTemp++;
        if (kTemp == k) {
          mTemp = mTemp + 1;
          kTemp = 0;
        }
      }
      if (kTemp == k) {
        mTemp = mTemp + 1;
      }
      if (mTemp >= m) {
        return temp[i];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] weights = {1,10,2,9,3,8,4,7,5,6};
    System.out.println(minDays(weights, 4, 2));
  }
}
