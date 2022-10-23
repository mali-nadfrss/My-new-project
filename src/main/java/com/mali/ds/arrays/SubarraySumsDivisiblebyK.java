package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/subarray-sums-divisible-by-k/ */
public class SubarraySumsDivisiblebyK {

  public static int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    int ans = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      int rem = Math.abs(sum) % k;
      if (map.get(rem) != null || rem == 0) {
        ans += map.getOrDefault(rem, 1);
      }
      map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    return ans;
  }

  public static void main(String[] args) {

    System.out.println(subarraysDivByK(new int[] {-1, 2, 9}, 2));
  }
}
