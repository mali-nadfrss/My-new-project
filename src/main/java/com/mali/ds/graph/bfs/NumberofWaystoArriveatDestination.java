package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/ */
public class NumberofWaystoArriveatDestination {

  public static int countPaths(int n, int[][] roads) {

    List<int[]>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] road : roads) {
      graph[road[0]].add(new int[] {road[1], road[2]});
      graph[road[1]].add(new int[] {road[0], road[2]});
    }
    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[0] = 0l;
    long[] path = new long[n];
    path[0] = 1;
    PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
    // node, prev, dist
    q.add(new long[] {0, 0});
    int MOD = 1000000007;
    while (!q.isEmpty()) {
      long[] cur = q.poll();
      int u = (int) cur[0];
      long d = cur[1];
      for (int[] road : graph[u]) {
        int v = road[0];
        int wt = road[1];
        if (dist[v] >= d + wt) {
          if (dist[v] == d + wt) {
            path[v] = path[v] + path[u] % MOD;
          } else {
            path[v] = path[u] % MOD;
            dist[v] = dist[u] + wt;
            q.add(new long[] {v, dist[v]});
          }
        }
      }
    }
    return (int) (path[n - 1] % MOD);
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] roads = {{0, 1, 1}, {1, 2, 4}, {0, 4, 3}, {3, 2, 5}, {3, 4, 1}, {3, 0, 5}, {1, 3, 1}};
    countPaths(n, roads);
  }
}
