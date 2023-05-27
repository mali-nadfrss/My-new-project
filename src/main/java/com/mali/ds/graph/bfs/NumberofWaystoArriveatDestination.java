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
    int[] path = new int[n];
    path[0] = 1;
    PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
    // node, prev, dist
    q.add(new long[] {0, 0});
    int ans = 0;
    int MOD = 1000000007;
    while (!q.isEmpty()) {
      long[] cur = q.poll();
      int u = (int) cur[0];
      for (int[] road : graph[u]) {
        int v = road[0];
        int wt = road[1];
        if (dist[v] >= dist[u] + wt) {
          if(dist[v] == dist[u] + wt){
            path[v] = path[v] + path[u] % MOD;
          } else {
            path[v] = path[u] % MOD;
            dist[v] = dist[u] + wt;
            q.add(new long[]{v,dist[v] });
          }
        }
      }
    }
    return path[n-1];
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] roads = {
      {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1},
      {0, 4, 5}, {4, 6, 2}
    };
    countPaths(n, roads);
  }
}
