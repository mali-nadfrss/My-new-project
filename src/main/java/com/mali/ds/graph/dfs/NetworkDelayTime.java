package com.mali.ds.graph.dfs;

import java.util.Arrays;

/* https://leetcode.com/problems/network-delay-time/
 * medium */
public class NetworkDelayTime {

  // use djikstra to find shortest path and return max of all
  public static int networkDelayTime_FloydWarshall(int[][] times, int n, int k) {
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < n; i++) {
      graph[i][i] = 0;
    }
    for (int[] i : times) {
      graph[i[0] - 1][i[1] - 1] = i[2];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int l = 0; l < n; l++) {
          if (graph[j][i] != Integer.MAX_VALUE
              && graph[i][l] != Integer.MAX_VALUE
              && graph[j][l] > graph[j][i] + graph[i][l]) {
            graph[j][l] = graph[j][i] + graph[i][l];
          }
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (graph[k - 1][i] == Integer.MAX_VALUE) {
        return -1;
      }
      ans = Math.max(ans, graph[k - 1][i]);
    }
    return ans;
  }

  public static int networkDelayTime_BellmanFord(int[][] times, int n, int k) {
    int ans = 0;

    return ans;
  }

  public static void main(String[] args) {
    int[][] q = {{1, 2, 1}, {2, 1, 3}, {1, 3, 2}};
    System.out.println(networkDelayTime_FloydWarshall(q, 3, 1));
  }
}
