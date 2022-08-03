package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * medium */
public class TimeNeededtoInformAllEmployees {

  // find the height of tree and return max such height.
  public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (manager[i] != -1) {
        map.computeIfAbsent(manager[i], k -> new ArrayList<>());
        map.get(manager[i]).add(i);
      }
    }
    return informTime[headID] + dfs(informTime, headID, map);
  }

  static int dfs(int[] informTime, int headID, Map<Integer, List<Integer>> map) {
    if (informTime[headID] == 0) return 0;
    int max = 0;
    for (int i : map.get(headID)) {
      max = Math.max(max, informTime[i] + dfs(informTime, i, map));
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(
        numOfMinutes(6, 2, new int[] {2, 2, -1, 2, 2, 2}, new int[] {0, 0, 1, 0, 0, 0}));
  }
}
