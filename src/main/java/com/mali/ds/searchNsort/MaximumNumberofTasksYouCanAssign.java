package com.mali.ds.searchNsort;

import java.util.Arrays;
import java.util.TreeMap;

/* https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/description/ */
public class MaximumNumberofTasksYouCanAssign {

  public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(tasks);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : workers) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    int ans = 0;
    for (int i = 0; i < tasks.length; i++) {
      Integer k = map.ceilingKey(tasks[i]);
      if (k != null && map.get(k) > 0) {
        map.put(k, map.get(k) - 1);
        ans++;
      } else if (pills > 0 && map.ceilingKey(tasks[i] - strength) != null) {
        ans++;
        pills--;
        k = map.ceilingKey(tasks[i] - strength);
        map.put(k, map.get(k) - 1);
      }
    }
    return ans;
  }
}
