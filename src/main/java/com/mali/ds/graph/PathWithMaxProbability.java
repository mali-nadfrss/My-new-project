package com.mali.ds.graph;

import com.mali.ds.algorithms.WeightedGraph;

/*
https://leetcode.com/problems/path-with-maximum-probability
Medium
 */
public class PathWithMaxProbability {
  // todo
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    WeightedGraph graph = new WeightedGraph(n, succProb.length);
    for (int i = 0; i < edges.length; i++) {
      graph.edge[i].src = edges[i][0];
      graph.edge[i].dest = edges[i][1];
      graph.edge[i].weight = succProb[i];
    }
    return 0d;
  }
}
