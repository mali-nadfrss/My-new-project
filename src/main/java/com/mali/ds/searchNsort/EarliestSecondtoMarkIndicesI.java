package com.mali.ds.searchNsort;

import java.util.Arrays;

public class EarliestSecondtoMarkIndicesI {

  public static int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {

    long needed = 0;

    for (int i = 0; i < nums.length; i++) {
      needed += nums[i];
    }

    if (needed + nums.length > changeIndices.length) {
      return -1;
    }

    int[] min = new int[nums.length];
    Arrays.fill(min, Integer.MAX_VALUE);
    for (int i = 0; i < changeIndices.length; i++) {
      min[changeIndices[i] - 1] = Math.min(min[changeIndices[i] - 1], i);
    }

    int m = 0;
    for (int i = 0; i < min.length; i++) {
      if (min[i] == Integer.MAX_VALUE) {
        return -1;
      }
      m = Math.max(m, min[i]);
    }

    // needed -= m+1-nums.length;
    int low = m + 1;
    int high = changeIndices.length;

    while (low < high) {
      int mid = (low + high) / 2;
      if (mid > needed + nums.length) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  boolean isValid(int low, int[] nums, int[] changeIndices, int needed) {

    int marked = 0;
    for (int i = 0; i < changeIndices.length; i++) {
      if (nums[changeIndices[i] - 1] == 0) {
        marked++;
      } else {

        needed--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3}, changeIndices = {1, 1, 1, 2, 1, 1, 1};
    earliestSecondToMarkIndices(nums, changeIndices);
  }
}
