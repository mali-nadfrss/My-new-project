package com.mali.ds.dp.greedy;

import java.util.TreeMap;

/* Given an array of integers nums and a positive integer k, check whether it is possible to divide this
array into sets of k consecutive numbers.
Return true if it is possible. Otherwise, return false.
Input : nums = [1,2,3,3,4,4,5,6], k = 4*/
public class DivideArrayinSetsofKConsecutiveNumbers {

  boolean isPossible(int[] nums, int k) {

    if (nums.length % k != 0) return false;

    TreeMap<Integer, Integer> map = new TreeMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    while (!map.isEmpty()) {
      int cur = map.ceilingKey(0);
      for (int i = cur; i < cur + k; i++) {
        if (map.get(i) == 0) return false;
        map.put(i, map.get(i) - 1);
        if (map.get(i) == 0) {
          map.remove(i);
        }
      }
    }

    return true;
  }
}
