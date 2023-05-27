package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/cheapest-flights-within-k-stops/ */
public class CheapestFlightsWithinKStops {

  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    int[] distance = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);

    List<int[]>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : flights) {
      graph[edge[0]].add(new int[] {edge[1], edge[2]});
      graph[edge[0]].add(new int[] {edge[0], edge[2]});
    }

    distance[src] = 0;
    // distance, node, hops
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    pq.add(new int[] {0, src, 0});
    int ans = Integer.MAX_VALUE;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      for (int[] edge : graph[cur[1]]) {
        if (distance[edge[0]] > distance[cur[1]] + edge[1] && cur[2] < k) {
          pq.add(new int[] {distance[cur[1]] + edge[1], edge[0], cur[2] + 1});
          distance[edge[0]] = distance[cur[1]] + edge[1];
        }
        if (edge[0] == dst) {
          ans = Math.min(ans, distance[cur[1]] + edge[1]);
        }
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
    int src = 0;
    int dst = 3;
    int k = 1;
    findCheapestPrice(n, flights, src, dst, k);
  }
}
