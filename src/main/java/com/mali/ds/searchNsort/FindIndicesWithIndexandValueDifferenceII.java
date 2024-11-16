package com.mali.ds.searchNsort;

import java.util.TreeMap;
import java.util.TreeSet;

/* https://leetcode.com/contest/weekly-contest-367/problems/find-indices-with-index-and-value-difference-ii/ */
public class FindIndicesWithIndexandValueDifferenceII {

  public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

    int n = nums.length;
    TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {

      int diff = nums[i] > valueDifference ? nums[i] - valueDifference : valueDifference + nums[i];
      map.putIfAbsent(nums[i], new TreeSet<>());
      map.get(nums[i]).add(i);
      if (map.floorKey(diff) != null) {
        Integer key = map.floorKey(diff);
        if (map.get(key).floor(i - indexDifference) != null) {
          return new int[] {i, map.get(key).floor(i - indexDifference)};
        }
      }
    }

    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {5, 1, 4, 1};
    int indexDifference = 2;
    int valueDifference = 4;
    findIndices(nums, indexDifference, valueDifference);
  }
}
