package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/number-of-operations-to-make-network-connected
 * medium */
public class NumberofOperationsMakeNetworkConnected {

  static int find(int x, int[] parent) {
    if (parent[x] != x) {
      parent[x] = find(parent[x], parent);
    }
    return parent[x];
  }

  static void union(int x, int y, int[] parent) {
    int xRoot = find(x, parent);
    int yRoot = find(y, parent);
    if (xRoot > yRoot) {
      parent[yRoot] = xRoot;
    } else if (yRoot > xRoot) {
      parent[xRoot] = yRoot;
    }
  }

  public static int makeConnected(int n, int[][] connections) {

    if (connections.length < n - 1) return -1;

    int[] parent = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < connections.length; i++) {
      union(connections[i][0], connections[i][1], parent);
    }

    int ans = 0;
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == i) ans++;
    }
    return ans - 1;
  }

  public static void main(String[] args) {
    System.out.println(
        makeConnected(
            8, new int[][] {{0, 6}, {2, 3}, {2, 6}, {2, 7}, {1, 7}, {2, 4}, {3, 5}, {0, 2}}));
  }
}
