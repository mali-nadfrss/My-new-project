package com.mali.ds.graph.unionFind;

/* https://leetcode.com/problems/redundant-connection/
 * medium */
public class RedundantConnection {
  public static int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[edges.length + 1];
    int[] ans = new int[2];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int[] edge : edges) {
      if (!union(edge[0], edge[1], parent)) {
        ans[0] = edge[0];
        ans[1] = edge[1];
      }
    }
    return ans;
  }

  static boolean union(int x, int y, int[] parent) {
    int xP = find(x, parent);
    int yP = find(y, parent);
    if (xP == yP) {
      return false;
    }
    if (xP > yP) {
      parent[xP] = yP;
    } else {
      parent[yP] = xP;
    }
    return true;
  }

  static int find(int x, int[] parent) {
    if (x != parent[x]) {
      parent[x] = find(parent[x], parent);
    }
    return parent[x];
  }

  public static void main(String[] args) {
    System.out.println(
        findRedundantConnection(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
  }
}
