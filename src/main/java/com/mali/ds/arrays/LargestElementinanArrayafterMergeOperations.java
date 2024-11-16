package com.mali.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-355/problems/largest-element-in-an-array-after-merge-operations/ */
public class LargestElementinanArrayafterMergeOperations {

  public static long maxArrayValue(int[] nums) {

    int cur = nums.length;
    int prev = cur + 1;
    List<Long> list = new ArrayList();
    for (int i : nums) {
      list.add((long) i);
    }
    while (prev > cur) {
      long count = 0;
      int len = list.size();
      List<Long> cuL = new ArrayList<>();
      count = list.get(len - 1);
      for (int i = len - 2; i >= 0; i--) {

        if (list.get(i) > count) {
          cuL.add(0, count);
          count = 0;
        }
        count += list.get(i);
      }
      cuL.add(0, count);
      list = cuL;
      prev = cur;
      cur = list.size();
    }
    long ans = 0;
    for (long i : list) {
      ans = Math.max(ans, i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {40, 15, 35, 98, 77, 79, 24, 62, 53, 84, 97, 16, 30, 22, 49};
    System.out.println(maxArrayValue(nums));
  }
}
