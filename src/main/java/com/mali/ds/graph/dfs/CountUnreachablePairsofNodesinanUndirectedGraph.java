package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/ */
public class CountUnreachablePairsofNodesinanUndirectedGraph {

  public static long countPairs(int n, int[][] edges) {

    long ans = n * (n - 1) / 2;

    List<Integer>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] road : edges) {
      graph[road[0]].add(road[1]);
      graph[road[1]].add(road[0]);
    }

    int[] vis = new int[n];
    for (int i = 0; i < n; i++) {
      if (vis[i] == 0) {
        long cnt = dfs(i, vis, graph);
        ans -= cnt * (cnt - 1) / 2;
      }
    }

    return ans;
  }

  static long dfs(int node, int[] vis, List<Integer>[] graph) {
    long ans = 1;
    vis[node] = 1;
    for (int child : graph[node]) {
      if (vis[child] == 0) {
        ans += dfs(child, vis, graph);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 100000;
    countPairs(n, new int[][] {{}});
  }
}
