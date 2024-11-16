package com.mali.ds.graph.dfs;

import java.util.ArrayList;

/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1  */
public class DetectCycleInUndirectedGraph {

  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < adj.size(); i++) {
      if (!visited[i] && bfs(visited, adj, i, -1)) {
        return true;
      }
    }
    return false;
  }

  public static boolean bfs(
      boolean[] visited, ArrayList<ArrayList<Integer>> adj, int node, int parent) {
    visited[node] = true;
    for (int n : adj.get(node)) {
      if (!visited[n] && bfs(visited, adj, n, node)) {
        return true;
      } else if (visited[n] && n != parent) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] graph = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
    System.out.println(isCycle(5, null));
  }
}
