package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/subarray-sum-equals-k/ */
public class SubarraySumEqualsK {
  public static int subarraySum(int[] nums, int k) {

    int ans = 0;
    int sum = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (map.containsKey(sum - k)) {
        ans += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int A[] = {1, -1, 0};
    System.out.println(subarraySum(A, 0));
  }
}
