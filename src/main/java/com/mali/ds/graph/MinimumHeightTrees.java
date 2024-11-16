package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* https://leetcode.com/problems/minimum-height-trees/submissions/ */
public class MinimumHeightTrees {

  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

    if (n == 1) return Collections.singletonList(0);
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (graph[i].size() == 1) {
        ans.add(i);
      }
    }

    while (n > 2) {
      n -= ans.size();
      List<Integer> current = new ArrayList<>();
      for (Integer node : ans) {
        int child = graph[node].get(0);
        graph[child].remove(node);
        if (graph[child].size() == 1) {
          current.add(child);
        }
      }
      ans = current;
    }

    return ans;
  }


  // using longest diameter of tree
  public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {

    List<Integer> ans = new ArrayList<>();
    List<Integer>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    int[] dist1 = new int[n];
    int[] dist2 = new int[n];
    int[] par = new int[n];
    par[0] = -1;
    dfs(-1, 0, graph, dist1, par);
    int max = 0;
    int u = 0;
    for (int i = 0; i < n; i++) {
      if (max < dist1[i]) {
        u = i;
        max = dist1[i];
      }
    }
    par[u] = -1;
    max = 0;
    dfs(-1, u, graph, dist2, par);
    for (int i = 0; i < n; i++) {
      if (max < dist2[i]) {
        u = i;
        max = dist2[i];
      }
    }
    while (u != -1) {
      ans.add(u);
      u = par[u];
    }
    if (ans.size() % 2 == 0) {
      return Arrays.asList(ans.get(ans.size() / 2 - 1), ans.get(ans.size() / 2));
    }
    return Collections.singletonList(ans.get(ans.size() / 2));
  }

  static void dfs(int parent, int node, List<Integer>[] graph, int[] dist1, int[] par) {

    for (int child : graph[node]) {
      if (child == parent) continue;
      par[child] = node;
      dist1[child] = dist1[node] + 1;
      dfs(node, child, graph, dist1, par);
    }
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
    findMinHeightTrees(n, edges);
    findMinHeightTrees2(n, edges);
  }
}
