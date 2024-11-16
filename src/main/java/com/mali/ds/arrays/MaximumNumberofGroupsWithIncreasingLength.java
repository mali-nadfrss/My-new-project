package com.mali.ds.arrays;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-355/problems/maximum-number-of-groups-with-increasing-length/ */
public class MaximumNumberofGroupsWithIncreasingLength {

  // try to form the triangle
  public static int maxIncreasingGroups(List<Integer> usageLimits) {
    Collections.sort(usageLimits);
    Map<Integer, Integer> map = new HashMap<>();
    int k = 0;
    for (int m : usageLimits) {
      for (; k < map.size() && m >= 0; k++, m--) {
        map.put(k, map.get(k) + 1);
      }
      if (k == map.size() && m > 0) {
        map.put(map.size(), 1);
        k = 0;
      }
    }
    return map.size();
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(1);
    //list.add(2);
    maxIncreasingGroups(list);
  }
}
