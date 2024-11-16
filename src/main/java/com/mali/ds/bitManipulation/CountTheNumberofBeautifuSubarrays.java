package com.mali.ds.bitManipulation;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/contest/weekly-contest-336/problems/count-the-number-of-beautiful-subarrays/ */
public class CountTheNumberofBeautifuSubarrays {

  public static long beautifulSubarrays(int[] nums) {

    long ans = 0;
    Map<Long, Long> map = new HashMap<>();
    long xor = 0;
    map.put(0L, 1L);
    for (int num : nums) {
      xor = xor ^ num;
      ans += map.getOrDefault(xor, 0L);
      map.put(xor, map.getOrDefault(xor, 0L) + 1);
    }

    return ans;
  }

  public static void main(String[] args) {
    beautifulSubarrays(new int[] {4, 3, 1, 2, 4});
  }
}
