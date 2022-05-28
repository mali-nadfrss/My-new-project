package com.mali.ds.searchNsort;

import java.util.Arrays;

/* https://leetcode.com/problems/magnetic-force-between-two-balls/
 * medium
 * same as cow darn */
public class MagneticForceBetweenTwoBalls {

  public static int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int len = position.length;
    int start = 0;
    int end = position[len - 1];
    int ans = 0;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (isPossible(position, m, mid)) {
        ans = Math.max(ans, mid);
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return ans;
  }

  static boolean isPossible(int[] position, int m, int ans) {
    int start = 0;
    for (int i = 0; i < position.length && m > 0; i++) {
      if (position[i] - position[start] >= ans) {
        start = i;
        m--;
      }
    }
    return m <= 1;
  }

  public static void main(String[] args) {
    int[] k = {1, 2, 3, 4, 7};
    System.out.println(maxDistance(k, 3));
  }
}
