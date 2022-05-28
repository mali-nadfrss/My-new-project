package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/contiguous-array/submissions/
 * medium */
public class ContiguousArray {

  public static int findMaxLength(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    int ans = 0;

    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      int k = nums[i] == 1 ? 1 : -1;
      sum += k;
      if (map.get(sum) != null) {
        ans = Math.max(ans, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[] {0, 1, 0, 1}));
  }
}
