package com.mali.ds.graph.dfs;

import java.util.*;

/* https://leetcode.com/problems/path-with-maximum-probability/ */
public class PathwithMaximumProbability {

  public static class Pair {

    int edge;
    double prob;

    Pair(int edge, double prob) {
      this.edge = edge;
      this.prob = prob;
    }
  }

  public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    List<Pair>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    int i = 0;
    for (int[] prereq : edges) {
      double prob = succProb[i++];
      graph[prereq[0]].add(new Pair(prereq[1], prob));
      graph[prereq[1]].add(new Pair(prereq[0], prob));
    }

    double[] prob = new double[n];
    prob[start] = 1;
    Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.prob));
    queue.add(new Pair(start, 1));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      if (pair.edge == end) {
        return pair.prob;
      }
      for (Pair child : graph[pair.edge]) {
        if (prob[child.edge] >= prob[pair.edge] * pair.prob) continue;
        prob[child.edge] = child.prob * pair.prob;
        queue.add(new Pair(child.edge, prob[child.edge]));
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
    double[] succProb = {0.5, 0.5, 0.2};
    int start = 0;
    int end = 2;
    maxProbability(n, edges, succProb, start, end);
  }
}
