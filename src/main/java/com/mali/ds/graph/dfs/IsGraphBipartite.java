package com.mali.ds.graph.dfs;

/* https://leetcode.com/problems/is-graph-bipartite/
 * medium */
public class IsGraphBipartite {

  public static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
      if (visited[i] == 0 && dfs(graph, visited, i, 1)) {
        return false;
      }
    }
    return true;
  }

  static boolean dfs(int[][] graph, int[] visited, int i, int value) {

    if (visited[i] == -value) {
      return true;
    }
    if (visited[i] == value) {
      return false;
    }
    visited[i] = value;
    for (int j = 0; j < graph[i].length; j++) {
      if (dfs(graph, visited, graph[i][j], -value)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] q = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    System.out.println(isBipartite(q));
  }
}
