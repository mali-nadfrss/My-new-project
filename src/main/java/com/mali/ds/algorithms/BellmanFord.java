package com.mali.ds.algorithms;

import java.util.Arrays;

// to find shortest path to all vertices from 1 vertex
// works with negative distances as well
public class BellmanFord {
  class Graph {
    class Edge {
      int src;
      int dest;
      int distance;
    }

    int V, E;
    Edge[] edge;

    void Graph(int V, int E) {
      this.V = V;
      this.E = E;

      for (int i = 0; i < E; i++) {
        edge[i] = new Edge();
      }
    }

    void bellmanFord(Graph graph, int src) {
      int[] dist = new int[V];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[src] = 0;
      boolean[] visited = new boolean[V];
      for (int i = 0; i < V - 1; i++) {
        int k = minDist(dist, visited);
        for (int j = 0; j < V; j++) {

        }
      }
    }

    int minDist(int[] dist, boolean[] visited) {
      int minDist = Integer.MAX_VALUE;
      int ans = 0;
      for (int i = 0; i < dist.length; i++) {
        if (!visited[i] && dist[i] < minDist) {
          minDist = dist[i];
          ans = i;
        }
      }
      visited[ans] = true;
      return ans;
    }
  }
}
