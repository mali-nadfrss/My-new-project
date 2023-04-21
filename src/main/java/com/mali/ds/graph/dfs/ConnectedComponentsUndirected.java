package com.mali.ds.graph.dfs;

import java.util.List;

/* https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/ */
public class ConnectedComponentsUndirected {

  static int connectedComponents(int V, List<List<Integer>> adj) {

    boolean[] visited = new boolean[V];
    int ans = 0;
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        ans++;
      }
    }
    return ans;
  }

  static void dfs(int vertex, boolean[] visited, List<List<Integer>> adj) {
    visited[vertex] = true;
    for (int node : adj.get(vertex)) {
      if (!visited[node]) {
        dfs(node, visited, adj);
      }
    }
  }

  // using disjoint set
  int merge(int[] parent, int child) {
    if (parent[child] == child) return child;
    return merge(parent, parent[child]);
  }

  static int disJointConnectedComponents(int V, List<List<Integer>> adj) {

    int[] parent = new int[V];
    for (int i = 0; i < V; i++) {
      parent[i] = i;
    }

    for (List<Integer> list : adj) {

    }

    int ans = 0 ;
    for (int i = 0; i < V; i++) {
      if (parent[i] == i)
        ans++;
    }

    return ans;
  }

  public static void main(String[] args) {}
}
