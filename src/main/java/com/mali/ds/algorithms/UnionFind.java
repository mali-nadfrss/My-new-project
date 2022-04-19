package com.mali.ds.algorithms;

public class UnionFind {

  class Graph {
    public int V;
    public int E;
    public Edge[] edges;

    public Graph(int V, int E) {
      this.V = V;
      this.E = E;
      edges = new Edge[E];
      for (int i = 0; i < E; i++) {
        edges[i] = new Edge();
      }
    }

    public class Edge {
      int src, dest;
    }
  }

  public static class Subset {
    public int parent;
    public int rank;
  }

  public static int find(int x, Subset[] subsets) {
    if (subsets[x].parent != x) {
      subsets[x].parent = find(subsets[x].parent, subsets);
    }
    return subsets[x].parent;
  }

  public static void union(int x, int y, Subset[] subsets) {
    int xRoot = find(x, subsets);
    int yRoot = find(y, subsets);
    if (subsets[xRoot].rank < subsets[yRoot].rank) {
      subsets[xRoot].parent = yRoot;
    } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
      subsets[yRoot].parent = xRoot;
    } else {
      subsets[xRoot].parent = yRoot;
      subsets[yRoot].rank++;
    }
  }

  public static int isCycle(Graph graph) {
    int V = graph.V;
    int E = graph.E;
    Subset[] subsets = new Subset[V];
    for (int i = 0; i < V; i++) {
      subsets[i] = new Subset();
      subsets[i].parent = i;
      subsets[i].rank = 0;
    }

    for (int i = 0; i < E; i++) {
      int x = find(graph.edges[i].src, subsets);
      int y = find(graph.edges[i].dest, subsets);
      if (x == y) {
        return 1;
      }
      union(x, y, subsets);
    }
    return 0;
  }
}
