package com.mali.ds.algorithms;

/* bellmanFord */
public class WeightedGraph {
  public class Edge {
    public int src, dest;
    public double weight;

    Edge() {
      src = dest = 0;
      weight = 0;
    }
  }

  public int V, E;
  public Edge[] edge;

  public WeightedGraph(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; i++) {
      edge[i] = new Edge();
    }
  }

  /* bellmanFord */
  void bellmanFord(WeightedGraph graph, int src) {
    int V = graph.V;
    int E = graph.E;
    int[] dist = new int[V];
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;
    for (int i = 1; i < V; i++) {
      for (int j = 0; j < E; j++) {
        int u = graph.edge[j].src;
        int v = graph.edge[j].dest;
        double weight = graph.edge[j].weight;
        /* bellmanFord */
        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
          dist[v] = (int) (dist[u] + weight);
        }
      }
    }
    for (int i = 0; i < E; i++) {
      int u = graph.edge[i].src;
      int v = graph.edge[i].dest;
      double weight = graph.edge[i].weight;
      if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
        System.out.println("cycle is present in graph");
      }
    }
  }

  public static void main(String[] args) {
    WeightedGraph graph = new WeightedGraph(5, 8);
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = -1;

    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 4;

    graph.edge[2].src = 1;
    graph.edge[2].dest = 2;
    graph.edge[2].weight = 3;

    graph.edge[3].src = 1;
    graph.edge[3].dest = 3;
    graph.edge[3].weight = 2;

    graph.edge[4].src = 1;
    graph.edge[4].dest = 4;
    graph.edge[4].weight = 2;

    graph.edge[5].src = 3;
    graph.edge[5].dest = 2;
    graph.edge[5].weight = 5;

    graph.edge[6].src = 3;
    graph.edge[6].dest = 1;
    graph.edge[6].weight = 1;

    graph.edge[7].src = 4;
    graph.edge[7].dest = 3;
    graph.edge[7].weight = -3;
    graph.bellmanFord(graph, 0);
  }
}
