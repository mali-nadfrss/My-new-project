package com.mali.ds.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* https://www.youtube.com/watch?v=XB4MIexjvY0&ab_channel=AbdulBari
 * algorithm */
public class Dijkstra {
  // works only for positive integers
  // finds shortest distance to each node from a particular node ( 1 to n)
  // if we want find shortest distance to every node from every node( n to n) then use flyod
  // warshall
  // use bellman ford for negative paths
  // algo
  static int INF = 100000;

  static void dijkstraShortestPath(int[][] graph, int n, int source) {
    boolean[] visitedNode = new boolean[n];
    int[] dist = new int[n];
    Arrays.fill(dist, INF);
    dist[source] = 0;

    for (int i = 0; i < n - 1; i++) {
      int vertex = minDistanceVertex(dist, source, visitedNode);
      for (int j = 0; j < graph.length; j++) {
        if (!visitedNode[i]
            && graph[vertex][j] != 0
            && dist[vertex] != Integer.MAX_VALUE
            && dist[vertex] + graph[vertex][j] < dist[j]) {
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

  // using pq

  static void dijkstra(int V, int source, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    pq.add(new int[] {source, 0});
    int[] dist = new int[V];
    Arrays.fill(dist, 100000);

    dist[source] = 0;
    while (!pq.isEmpty()) {
      int node = pq.peek()[0];
      int distance = pq.poll()[1];

      for (ArrayList<Integer> list : adj.get(node)) {
        int adjDist = list.get(1);
        int adjNode = list.get(0);
        if (dist[adjNode] > distance + adjDist) {
          dist[adjNode] = distance + adjDist;
          pq.add(new int[] {adjNode, dist[adjNode]});
        }
      }

      for (int i = 0; i < V; i++) {
        System.out.println(dist[i]);
      }
    }
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
