package com.mali.ds.graph.bfs;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-346/problems/modify-graph-edge-weights/ */
public class ModifyGraphEdgeWeights {

  //todo
  public static int[][] modifiedGraphEdges(
          int n, int[][] edges, int source, int destination, int target) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    List<int[]>[] graph = new List[n];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(new int[] {edge[1], edge[2]});
      graph[edge[1]].add(new int[] {edge[0], edge[2]});
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    pq.add(new int[] {source, 0});
    dist[source] = 0;
    while (!pq.isEmpty()) {
      int[] p = pq.poll();
      int cur = p[0];
      if (cur == destination) {
        return bfs2(edges, graph, source, destination, target, dist);
      }
      for (int[] edge : graph[cur]) {
        int k = edge[1] < 0 ? 1 : edge[1];
        if (dist[cur] + k < dist[edge[0]]) {
          pq.add(new int[] {edge[0], dist[cur] + k});
          dist[edge[0]] = dist[cur] + k;
        }
      }
    }
    return null;
  }

  static int[][] bfs2(
      int[][] edges, List<int[]>[] graph, int source, int destination, int target, int[] dist) {

    int[] needed = new int[2];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    pq.add(new int[] {destination, 0});
    int count = 0;
    while (!pq.isEmpty()) {
      int[] p = pq.poll();
      int cur = p[0];
      if (cur == source) break;
      for (int[] edge : graph[cur]) {
        int k = edge[1] < 0 ? 1 : edge[1];
        if (dist[edge[0]] == dist[cur] - k) {
          if (edge[1] > 0) {
            count += edge[1];
          }else{
            count++;
            needed = new int[] {edge[0], cur};
          }
          pq.add(new int[] {edge[0], dist[edge[0]]});
          break;
        }
      }
    }
    if (count > target) return null;
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      if (edge[0] == needed[0] && edge[1] == needed[1]
              || edge[0] == needed[1] && edge[1] == needed[0]) {
        edges[i][2] = target - count+1;
      }
      if(edge[2] < 0 ){
        edges[i][2] = 1;
      }
    }

    return edges;
  }

  public static void main(String[] args) {

   /* int n = 5;
    int[][] edges = {{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}};
    int source = 0, destination = 1, target = 5;*/

    int n = 3;
    int[][] edges = {{0,1,-1},{0,2,5}};
    int source = 0, destination = 2, target = 6;
    modifiedGraphEdges(n, edges, source, destination, target);
  }
}
