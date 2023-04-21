package com.mali.ds.graph;

import java.util.Arrays;

/* https://leetcode.com/problems/longest-cycle-in-a-graph/description/ */
public class LongestCycleInAGraph {

  public static int longestCycle(int[] edges) {

    int len = edges.length;

    int ans = -1;
    int[] dist = new int[len];
    Arrays.fill(dist, -1);

    for (int i = 0; i < len; i++) {
      if (dist[i] != -1) continue;
      int cur = i;
      int prev = cur;

      while (cur != -1 && edges[cur] != -1) {

        if (dist[cur] != -1) {
          ans = Math.max(ans, dist[prev] - dist[cur] + 1);
          break;
        } else {
          dist[cur] = dist[prev] + 1;
        }
        prev = cur;
        cur = edges[cur];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] edge = {-1, 4, -1, 2, 0, 4};
    System.out.println(longestCycle(edge));
  }
}
