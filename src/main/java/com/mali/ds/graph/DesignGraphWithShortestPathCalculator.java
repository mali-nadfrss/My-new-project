package com.mali.ds.graph;

import java.util.List;

/* https://leetcode.com/contest/biweekly-contest-102/problems/design-graph-with-shortest-path-calculator/  */
public class DesignGraphWithShortestPathCalculator {

  class Graph {

    int vertex;
    List<int[]> edges;

    Graph(int vertex) {
      this.vertex = vertex;
    }
  }

  public DesignGraphWithShortestPathCalculator(int n, int[][] edges) {}

  public void addEdge(int[] edge) {}

  public int shortestPath(int node1, int node2) {
    return -1;
  }
}

/**
 * Your Graph object will be instantiated and called as such: Graph obj = new Graph(n, edges);
 * obj.addEdge(edge); int param_2 = obj.shortestPath(node1,node2);
 */
