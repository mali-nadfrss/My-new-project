package com.mali.ds.graph;

import java.util.Arrays;

/* https://leetcode.com/problems/min-cost-to-connect-all-points/ */
public class MinCosttoConnectAllPoints {

  public static int minCostConnectPoints(int[][] points) {

    int n = points.length;
    int ans = 0;
    int i = 0;
    int dist[] = new int[n];
    Arrays.fill(dist, 1000000);
    int cnt = 0;
    while (++cnt < n) {
      int min = i;
      dist[i] = Integer.MAX_VALUE;
      for (int j = 0; j < n; j++) {
        if (dist[j] != Integer.MAX_VALUE) {
          dist[j] =
              Math.min(
                  dist[j],
                  Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]));
          min = dist[j] < dist[min] ? j : min;
        }
      }
      ans += dist[min];
      i = min;
    }

    return ans;
  }

  public static void main(String[] args) {
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    minCostConnectPoints(points);
  }
}
