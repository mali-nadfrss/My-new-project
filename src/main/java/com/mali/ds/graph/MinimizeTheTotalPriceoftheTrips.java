package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/contest/weekly-contest-341/problems/minimize-the-total-price-of-the-trips/ */
public class MinimizeTheTotalPriceoftheTrips {

  public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
    List<Integer>[] graph = addGraph(n, edges);
    Map<Integer, Integer> edgeCnt = calEdgeCnt(graph, trips);
    int[] dp = dp(-1, 0, graph, price, edgeCnt);
    return Math.min(dp[0], dp[1]);
  }

  int[] dp(
      int parent, int node, List<Integer>[] graph, int[] price, Map<Integer, Integer> edgeCnt) {

    int[] res = new int[2];
    for (int edge : graph[node]) {
      if (edge == parent) continue;
      int[] edgeRes = dp(node, edge, graph, price, edgeCnt);
      res[0] += edgeRes[1];
      res[1] += Math.min(edgeRes[0], edgeRes[1]);
    }
    res[0] += (price[node] / 2) * edgeCnt.get(node);
    res[1] += (price[node]) * edgeCnt.get(node);
    return res;
  }

  Map<Integer, Integer> calEdgeCnt(List<Integer>[] graph, int[][] trips) {
    Map<Integer, Integer> edgeCnt = new HashMap<>();
    for (int[] trip : trips) {
      List<Integer> path = new ArrayList<>();
      calpath(-1, trip[0], trip[1], graph, path);
      for (int edge : path) {
        edgeCnt.put(edge, edgeCnt.getOrDefault(edge, 0) + 1);
      }
    }
    return edgeCnt;
  }

  boolean calpath(int parent, int src, int dest, List<Integer>[] graph, List<Integer> path) {
    path.add(src);
    if (src == dest) return true;
    for (int edge : graph[src]) {
      if (edge == parent) continue;
      if (calpath(src, edge, dest, graph, path)) return true;
    }
    path.remove(path.size() - 1);
    return false;
  }

  List<Integer>[] addGraph(int n, int[][] edges) {
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    return graph;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] edges = {{0, 1}, {1, 2}, {1, 3}};
    int[] price = {2, 2, 10, 6};
    int[][] trips = {{0, 3}, {2, 1}, {2, 3}};
    MinimizeTheTotalPriceoftheTrips m = new MinimizeTheTotalPriceoftheTrips();
    m.minimumTotalPrice(n, edges, price, trips);
  }
}
