package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/ */
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

  public static int minReorder(int n, int[][] connections) {

    int in = 1;
    int out = -1;
    ans = 0;
    List<int[]>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] connection : connections) {
      graph[connection[0]].add(new int[] {connection[1], out});
      graph[connection[1]].add(new int[] {connection[0], in});
    }
    dfs(graph, 0, -1);
    return ans;
  }
  static int ans = 0;
  static void dfs(List<int[]>[] graph, int current, int parent) {
    for (int[] child : graph[current]) {
      if (child[0] != parent) {
        if (child[1] == -1) ans++;
        dfs(graph, child[0], current);
      }
    }
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    minReorder(n, connections);
  }


}
