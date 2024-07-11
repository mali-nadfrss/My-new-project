package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/number-of-subarrays-with-and-value-of-k/ */
public class NumberOfSubArraysWithAndValueK {

  public static void main(String[] args) {
    int[] arr = {2, 1, 2, 4, 0};
    countSubarrays(arr, 0);
  }

  public static long countSubarrays(int[] nums, int k) {

    long ans = 0;
    int len = nums.length;
    Map<Integer, Long> all = new HashMap<>();
    all.put(nums[0], 1l);
    if (nums[0] == k) {
      ans++;
    }
    for (int i = 1; i < len; i++) {
      if (nums[i] == k) {
        ans++;
      }

      Map<Integer, Long> temp = new HashMap<>();
      temp.put(nums[i], 1l);
      for (int key : all.keySet()) {
        int cur = key & nums[i];
        if (cur == k) {
          ans += all.get(key);
        }
        temp.put(cur, all.get(key) + temp.getOrDefault(cur, 0l));
      }
      all = temp;
    }

    return ans;
  }
}
