package com.mali.ds.searchNsort;

/* https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/ */
public class MinimumGardenPerimetertoCollectEnoughApples {

  public static long minimumPerimeter(long neededApples) {

    long min = 0;
    long max = 10000;

    while (min < max) {
      long mid = min + (max - min) / 2;
      if (mid * mid * mid * 4 + mid * mid * 6 + mid * 2 <= neededApples) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min * 8;
  }

  public static void main(String[] args) {
    System.out.println(minimumPerimeter(1000000000));
  }
}
