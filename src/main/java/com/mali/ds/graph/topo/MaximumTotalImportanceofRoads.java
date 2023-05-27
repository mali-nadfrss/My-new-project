package com.mali.ds.graph.topo;

import java.util.Arrays;
import java.util.Comparator;

/* https://leetcode.com/problems/maximum-total-importance-of-roads/ */
public class MaximumTotalImportanceofRoads {

  public static long maximumImportance(int n, int[][] roads) {
    int[][] deg = new int[n][2];
    for (int i = 0; i < roads.length; i++) {
      deg[roads[i][0]] =
          new int[] {
            deg[roads[i][0]][0] + 1, roads[i][0],
          };
      deg[roads[i][1]] =
          new int[] {
            deg[roads[i][1]][0] + 1, roads[i][1],
          };
    }
    Arrays.sort(deg, Comparator.comparingInt(o-> o[0]));
    int count = 0;
    int ans = 0;
    while (count < n) {
      ans += deg[count][0] * ++count;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
    maximumImportance(n, roads);
  }
}
