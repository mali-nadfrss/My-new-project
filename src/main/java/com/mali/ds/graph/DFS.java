package com.mali.ds.graph;

import java.util.Iterator;

public class DFS {

  public static void dfsUtil(Graph<Integer> g, boolean[] visited, int i) {
    visited[i] = true;
    System.out.println("i:" + i);
    Iterator<Integer> it = g.getArr(i).iterator();
    while (it.hasNext()) {
      if (!visited[it.next()]) {
        dfsUtil(g, visited, it.next());
      }
    }
  }

  public static void dfs(Graph<Integer> g) {
    boolean[] visited = new boolean[g.getVertices()];
    for (int i = 0; i < g.getVertices(); i++) {
      if (!visited[i]) dfsUtil(g, visited, i);
    }
  }

  public static void main(String args[]) {
    Graph g = new Graph<Integer>(6);
    g.add(0, 1);
    g.add(0, 2);
    g.add(0, 3);
    g.add(3, 2);
    g.add(4, 5);
    dfs(g);
  }
}
