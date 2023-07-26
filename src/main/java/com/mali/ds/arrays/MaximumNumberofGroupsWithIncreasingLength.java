package com.mali.ds.arrays;

import java.util.Collections;
import java.util.List;

/* https://leetcode.com/contest/weekly-contest-355/problems/maximum-number-of-groups-with-increasing-length/ */
public class MaximumNumberofGroupsWithIncreasingLength {

  public int maxIncreasingGroups(List<Integer> usageLimits) {
    Collections.sort(usageLimits);
    int ans = 0;
    for (int i = 1; i < usageLimits.size(); i++) {
      if (usageLimits.get(i) > usageLimits.get(i-1)){
        ans++;
      }
    }
  }
}
