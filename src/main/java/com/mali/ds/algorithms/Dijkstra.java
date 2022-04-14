package com.mali.ds.algorithms;

import java.util.Arrays;

/* https://www.youtube.com/watch?v=XB4MIexjvY0&ab_channel=AbdulBari
 * algorithm */
public class Dijkstra {
  // works only for positive integers
  // finds shortest distance to each node from a particular node ( 1 to n)
  // if we want find shortest distance to every node from every node( n to n) then use bellman ford
  // algo
  static int INF = 100000;

  static void dijkstraShortestPath(int[][] graph, int n, int source) {
    boolean[] visitedNode = new boolean[n];
    int[] dist = new int[n];
  Arrays.fill(dist, INF);
    dist[source] = 0;

    for (int i = 0; i < graph.length; i++) {
      int vertex = minDistanceVertex(dist, source, visitedNode);
      for (int j = 0; j < graph.length; j++) {
        if (!visitedNode[i]
            && graph[vertex][j] != 0
            && dist[i] < INF
            && dist[vertex] + graph[vertex][j] < dist[i]) {
          dist[j] = dist[vertex] + graph[vertex][j];
        }
      }
    }
    for (int i : dist) {
      System.out.println(i);
    }
  }

  static int minDistanceVertex(int[] dist, int source, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int ans = source;
    for (int i = 0; i < dist.length; i++) {
      if (!visited[i] && dist[i] <= min) {
        min = dist[i];
        ans = i;
      }
    }
    visited[ans] = true;
    return ans;
  }

  public static void main(String[] args) {
    int[][] graph =
        new int[][] {
          {0, 4, 0, 0, 0, 0, 0, 8, 0},
          {4, 0, 8, 0, 0, 0, 0, 11, 0},
          {0, 8, 0, 7, 0, 4, 0, 0, 2},
          {0, 0, 7, 0, 9, 14, 0, 0, 0},
          {0, 0, 0, 9, 0, 10, 0, 0, 0},
          {0, 0, 4, 14, 10, 0, 2, 0, 0},
          {0, 0, 0, 0, 0, 2, 0, 1, 6},
          {8, 11, 0, 0, 0, 0, 1, 0, 7},
          {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

    dijkstraShortestPath(graph, 9, 0);
  }
}
