package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumFuelCosttoReporttotheCapital {

  public long minimumFuelCost(int[][] roads, int seats) {

    int len = roads.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int[] i : roads) {
      if (map.get(i[0]) != null) {
        List<Integer> list = new ArrayList<>();
        list.add(i[1]);
        map.put(i[0], list);
      } else {
        map.get(i[0]).add(i[1]);
      }

      if (map.get(i[1]) != null) {
        List<Integer> list = new ArrayList<>();
        list.add(i[0]);
        map.put(i[1], list);
      } else {
        map.get(i[1]).add(i[0]);
      }
      inDegree.put(i[0], inDegree.getOrDefault(i[0], 0)+1);
      inDegree.put(i[1], inDegree.getOrDefault(i[1], 0)+1);
    }
    boolean[] visited = new boolean[len];
    visited[0] = true;
    return ans;
  }

  long ans = 0;

  void recursion(Map<Integer, List<Integer>> map, int city, int distance, int seats, int left) {
    if (map.get(city) == null) return;
    if (left <= 0) {
      ans += distance;
      left = seats;
    }

    for (int i : map.get(city)) {
      ans++;
      recursion(map, i, distance + 1, seats, left - 1);
    }
  }
}
