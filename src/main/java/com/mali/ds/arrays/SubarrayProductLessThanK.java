package com.mali.ds.arrays;

/* https://leetcode.com/problems/subarray-product-less-than-k/ */
public class SubarrayProductLessThanK {

  // use 2 pointer approach, when product becomes more remove last one and check if it fits
  // add len of 2 pointers each time
  // corner cases : when k is 0, k = 1,
  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    // subarray means continuos, subset means random pick(sortig allowed)
    int ans = 0;
    int len = nums.length;
    int prod = 1;
    int j = 0; // 0
    for (int i = 0; i < len; i++) {
      // 10,5,2,6 k = 100
      prod = prod * nums[i]; // 60,3
      while (prod >= k && i >= j) {
        prod = prod / nums[j];
        j += 1; // 1
      }
      ans += i - j + 1; // 1, [10], [10, 5], [5], [2], [5,2],[5,2,6], [2,6],[6]
    }
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
  }
}
