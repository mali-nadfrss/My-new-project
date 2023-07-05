package com.mali.ds.trees.segmentTree;

/* https://leetcode.com/problems/sliding-subarray-beauty/description/ */
public class SlidingSubarrayBeauty {

  public static int[] getSubarrayBeauty(int[] nums, int k, int x) {

    int len = nums.length;
    int[] arr = new int[103];
    int[] ans = new int[len - k + 1];

    for (int i = 0; i < k; i++) {
      arr[nums[i] + 50]++;
    }

    ans[0] = Math.min(min(arr, x), 0);

    for (int i = k; i < len; i++) {
      arr[nums[i - k] + 50]--;
      arr[nums[i] + 50]++;
      ans[i - k + 1] = Math.min(min(arr, x), 0);
    }

    return ans;
  }

  static int min(int[] arr, int x) {
    int i = -1;
    while (x > 0 && i++ < 103) {
      if (arr[i] > 0) x -= arr[i];
    }
    if (x <= 0) return i - 50;
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {-14, 9, 13, -26, 47, -39, -49, -14, 29};
    int k = 9, x = 4;
    getSubarrayBeauty(nums, k, x);
  }
}
