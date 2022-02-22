package com.mali.ds.dp.distinctWays;

/*
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 * Hard
 * */
public class MinimumSwapsToMakeSequencesIncreasing {

  public int minSwap(int[] nums1, int[] nums2) {
    int ans = 0;
    for (int i = 1; i < nums1.length; i++) {
      if (nums1[i - 1] > nums1[i]) {
        swap(nums2, nums1, i);
        ans++;
      }
    }

    for (int i = 1; i < nums2.length; i++) {
      if (nums2[i - 1] > nums2[i]) {
        swap(nums1, nums2, i);
        ans++;
      }
    }
    return ans;
  }

  void swap(int[] nums2, int[] nums1, int i) {
    for (int j = nums2.length - 1; j >= 0; j--) {
      if (nums1[i] < nums2[j]) {
        int temp = nums2[j];
        nums2[j] = nums1[i];
        nums1[i] = temp;
        return;
      }
    }
    int temp = nums2[nums2.length - 1];
    nums2[nums2.length - 1] = nums1[i];
    nums1[i] = temp;
  }
}
