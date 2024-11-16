package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumFuelCosttoReporttotheCapital {

  public static long minimumFuelCost(int[][] roads, int seats) {
    ans = 0;
    int n = roads.length + 1;
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      graph[roads[i][0]].add(roads[i][1]);
      graph[roads[i][1]].add(roads[i][0]);
    }
    dfs(graph, 0, seats, -1);
    return ans;
  }

  static long ans = 0;

  static int dfs(List<Integer>[] graph, int current, int seats, int parent) {
    int cnt = 1;
    for (int child : graph[current]) {
      if (child != parent) {
        cnt += dfs(graph, child, seats, current);
      }
    }
    if (current != 0)
    ans += (cnt - 1) / seats + 1;
    return cnt;
  }

  public static void main(String[] args) {
    int[][] roads = {{1, 0}, {1, 2}, {3, 2}, {4, 1}, {0, 5}, {6, 5}, {5, 7}};
    minimumFuelCost(roads, 7);
  }
}
