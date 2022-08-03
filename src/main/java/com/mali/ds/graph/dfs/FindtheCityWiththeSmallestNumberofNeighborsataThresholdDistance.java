package com.mali.ds.graph.dfs;

import java.util.Arrays;

/* https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
medium */
public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {

  /* flyod warshall algo to find shortest path b/w nodes */
  public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] dis = new int[n][n];
    for (int[] row : dis) Arrays.fill(row, 10001);
    for (int i = 0; i < edges.length; i++) {
      dis[edges[i][0]][edges[i][1]] = dis[edges[i][1]][edges[i][0]] = edges[i][2];
    }
    for (int i = 0; i < n; i++) {
      dis[i][i] = 0;
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dis[i][j] > dis[i][k] + dis[k][j]) {
            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
          }
        }
      }
    }

    int ans = -1;
    int minCount = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      int count = 0;
      for (int k = 0; k < n; k++) {
        if (dis[j][k] <= distanceThreshold) {
          count += 1;
        }
      }
      if (count <= minCount) {
        ans = j;
        minCount = count;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        findTheCity(
            5, new int[][] {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
  }
}
