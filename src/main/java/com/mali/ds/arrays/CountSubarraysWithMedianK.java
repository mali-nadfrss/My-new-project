package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/count-subarrays-with-median-k/ */
public class CountSubarraysWithMedianK {

  public static int countSubarrays(int[] nums, int k) {

    int index = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == k) {
        index = i;
        break;
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int bal = 0;
    for (int i = index; i < len; i++) {
      bal += Integer.compare(nums[i], nums[index]);
      map.put(bal, map.getOrDefault(bal, 0) + 1);
    }

    bal = 0;
    int ans = 0;
    for (int i = index; i >= 0; i--) {
      bal += Integer.compare(nums[i], nums[index]);
      ans += map.getOrDefault(-bal, 0);
      ans += map.getOrDefault(-bal + 1, 0);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(countSubarrays(new int[] {3, 2, 1, 4, 5}, 4));
  }
}
