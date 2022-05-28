package com.mali.ds.graph.unionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* https://leetcode.com/problems/find-eventual-safe-states/
 * medium */
public class FindEventualSafeStates {
  public static List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    int[] parent = new int[n];

    Set<Integer> terminal = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (graph[i].length == 0) {
        terminal.add(i);
        parent[i] = 1;
      }
    }

    for (int i = 0; i < n; i++) {
      if (parent[i] == 0) {
        parent[i] = dfs(parent, graph, i, terminal);
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (parent[i] == 1) {
        ans.add(i);
      }
    }
    return ans;
  }

  static int dfs(int[] parent, int[][] graph, int i, Set<Integer> set) {
    if (parent[i] != 0) {
      return parent[i];
    }
    parent[i] = 2;
    if (set.contains(i)) {
      parent[i] = 1;
      return 1;
    }
    for (int j = 0; j < graph[i].length; j++) {
      int k = dfs(parent, graph, graph[i][j], set);
      if (k != 1) {
        parent[i] = 2;
        return 2;
      }
    }
    parent[i] = 1;
    return 1;
  }

  public static void main(String[] args) {
    int[][] q = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
    System.out.println(eventualSafeNodes(q));
  }
}
