package com.mali.ds.graph.unionFind;

import java.util.Arrays;

/* https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/ */
public class RemoveMaxNumberofEdgestoKeepGraphFullyTraversable {

  public static int maxNumEdgesToRemove(int n, int[][] edges) {
    Arrays.sort(edges, (a, b) -> b[0] - a[0]);
    int[] parenta = new int[n + 1];
    int[] parentb = new int[n + 1];

    int[] ranka = new int[n + 1];
    int[] rankb = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parenta[i] = i;
      parentb[i] = i;
      ranka[i] = 1;
      rankb[i] = 1;
    }
    int counta = 1;
    int countb = 1;
    int remove = 0;
    for (int[] edge : edges) {
      if (edge[0] == 3) {
        boolean a = unionFind(edge[1], edge[2], parenta, ranka);
        boolean b = unionFind(edge[1], edge[2], parentb, rankb);
        if (a) counta++;
        if (b) countb++;
        if (!a && !b) remove++;
      } else if (edge[0] == 2) {
        if (unionFind(edge[1], edge[2], parenta, ranka)) {
          counta++;
        } else {
          remove++;
        }
      } else {
        if (unionFind(edge[1], edge[2], parentb, rankb)) {
          countb++;
        } else {
          remove++;
        }
      }
    }
    if (counta < n || countb < n) return -1;
    return remove;
  }

  static int find(int x, int[] parent) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x], parent);
  }

  static boolean unionFind(int x, int y, int[] parent, int[] rank) {
    int a = find(x, parent);
    int b = find(y, parent);
    if (a != b) {
      if (rank[a] > rank[b]) {
        parent[b] = a;
        rank[a]++;
        return true;
      } else {
        parent[a] = b;
        rank[b]++;
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
    maxNumEdgesToRemove(n, edges);
  }
}
