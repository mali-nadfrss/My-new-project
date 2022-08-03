package com.mali.ds.graph.dfs;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/longest-cycle-in-a-graph/
 * Hard */
public class LongestCycleinaGraph {

  static int ans = -1;

  public static int longestCycle(int[] edges) {

    int len = edges.length;
    boolean[] visited = new boolean[len];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < len; i++) {
      if (!visited[i]) {
        int dist = 0;
        int k = i;
        while (k != -1) {
          if (visited[k]) {
            ans = Math.max(ans, dist - map.get(k));

            break;
          }
          if (edges[k] == -1) break;
          visited[k] = true;
          map.put(k, dist++);
          k = edges[k];
        }
      }
    }
    return ans;
  }

  public static void main(String args[]) {
    int[] words1 = {-1, 4, -1, 2, 0, 4};
    System.out.println(longestCycle(words1));
  }
}
