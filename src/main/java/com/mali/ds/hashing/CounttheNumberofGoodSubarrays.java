package com.mali.ds.hashing;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/contest/weekly-contest-328/problems/count-the-number-of-good-subarrays/ */
public class CounttheNumberofGoodSubarrays {

  public static long countGood(int[] nums, int k) {

    long ans = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0, j = 0; j < nums.length; j++) {
      k -= map.getOrDefault(nums[j], 0);
      map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

      while (k <= 0) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
        k += map.getOrDefault(nums[i++], 0);
      }
      ans += i;
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1, 1};
    System.out.println(countGood(nums, 10));
  }
}
