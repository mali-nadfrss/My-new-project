package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/ */
public class NumberofRestrictedPathsFromFirsttoLastNode {

  class Pair {
    int node;
    int distance;
    List<Integer> path;

    Pair(int node, int distance) {
      this.node = node;
      this.distance = distance;
      this.path = new ArrayList<>();
    }
  }

  public int countRestrictedPaths(int n, int[][] edges) {

    Map<Integer, Integer>[] graph = new Map[n + 1];
    for (int i = 0; i < n; i++) {
      graph[i] = new HashMap<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].put(edge[1], edge[2]);
      graph[edge[1]].put(edge[0], edge[2]);
    }

    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
    queue.add(new Pair(n, 0));
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[n] = 0;
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      for(Map.Entry<Integer, Integer> entry : graph[p.node].entrySet()){
        if(dist[entry.getKey()] < dist[p.node]+entry.getValue()){

        }
      }
    }
    int ans = 0;
    int modulo = 1000000007;
    return 0;
  }
}
