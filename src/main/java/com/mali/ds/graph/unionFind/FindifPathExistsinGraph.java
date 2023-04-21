package com.mali.ds.graph.unionFind;

/* https://leetcode.com/problems/find-if-path-exists-in-graph/ */
public class FindifPathExistsinGraph {

  public boolean validPath(int n, int[][] edges, int source, int destination) {

    int[] par = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      par[i] = i;
      rank[i] = i;
    }
    for (int[] edge : edges) {
      union(edge[0], edge[1], par, rank);
    }
    return find(source, par) == find(destination, par);
  }

  void union(int u, int v, int[] par, int rank[]) {
    if (u != v) {
      int a = find(u, par);
      int b = find(v, par);
      if (rank[a] > rank[b]) {
        par[b] = a;
        rank[a] += rank[b];
      } else {
        par[a] = b;
        rank[b] += rank[a];
      }
    }
  }

  int find(int u, int[] par) {
    if (u != par[u]) {
      par[u] = find(par[u], par);
    }
    return par[u];
  }
}
