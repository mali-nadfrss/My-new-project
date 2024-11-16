package com.mali.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/contest/weekly-contest-375/problems/count-the-number-of-good-partitions/ */
public class CounttheNumberofGoodPartitions {

  public static int numberOfGoodPartitions(int[] nums) {

    Map<Integer, int[]> map = new HashMap<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int index = i;
      map.computeIfAbsent(nums[i], k -> new int[] {index, -1});
    }
    for (int i = len - 1; i >= 0; i--) {
      if (map.get(nums[i])[1] == -1) {
        map.get(nums[i])[1] = i;
      }
    }
    int count = 0;
    for (int i = 0; i < len; i++) {
      int current = map.get(nums[i])[1];
      while (i < len - 1 && i < current) {
        current = Math.max(current, map.get(nums[++i])[1]);
      }
      count++;
    }
    return (int) Math.pow(2, count - 1);
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 1};
    System.out.println(numberOfGoodPartitions(nums));
  }
}
