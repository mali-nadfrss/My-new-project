package com.mali.ds.searchNsort;

/* https://leetcode.com/problems/split-array-largest-sum/
 * Hard */
public class SplitArrayLargestSum {

  public static int splitArray(int[] nums, int m) {
    int max = 0;
    int total = 0;

    for (int i : nums) {
      if (i > max) {
        max = i;
      }
      total += i;
    }

    while (max <= total) {
      int mid = max + (total - max) / 2;
      if (binarySearch(nums, mid, m)) {
        total = mid - 1;
      } else {
        max = mid + 1;
      }
    }
    return max;
  }

  static boolean binarySearch(int[] nums, int mid, int m) {
    int ans = 0;
    int sum = 0;
    int count = 0;
    for (int i : nums) {
      sum += i;
      if (sum >= mid) {
        ans = Math.max(ans, sum);
        count++;
        sum = 0;
      }
    }
    return m >= count;
  }

  public static void main(String[] args) {
    int[] weights = {7, 2, 5, 10, 8};
    System.out.println(splitArray(weights, 2));
  }
}
