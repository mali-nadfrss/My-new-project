package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/problems/the-time-when-the-network-becomes-idle/ */
public class TheTimeWhentheNetworkBecomesIdle {

  public static int networkBecomesIdle(int[][] edges, int[] patience) {

    int n = patience.length;
    int[] dis = new int[n];
    Arrays.fill(dis, -1);
    dis[0] = 0;
    List<Integer>[] graph = new List[n + 1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] road : edges) {
      graph[road[0]].add(road[1]);
      graph[road[1]].add(road[0]);
    }
    int distance = 1;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int current = queue.poll();
        for (int child : graph[current]) {
          if (dis[child] == -1) {
            dis[child] = distance;
            queue.add(child);
          }
        }
      }
      distance++;
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (patience[i] < 2 * dis[i]) {
        int msgs = (2 * dis[i]-1)/patience[i];
        ans = Math.max(ans, 2 * dis[i] + msgs + patience[i]);
      } else {
        ans = Math.max(ans, 2 * dis[i] + 1);
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int[][] edges = {
      {3, 8}, {4, 13}, {0, 7}, {0, 4}, {1, 8}, {14, 1}, {7, 2}, {13, 10}, {9, 11}, {12, 14}, {0, 6},
      {2, 12}, {11, 5}, {6, 9}, {10, 3}
    };
    int[] patience = {0, 3, 2, 1, 5, 1, 5, 5, 3, 1, 2, 2, 2, 2, 1};
    networkBecomesIdle(edges, patience);
  }
}
