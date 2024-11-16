package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* https://leetcode.com/problems/maximum-star-sum-of-a-graph/ */
public class MaximumStarSumofaGraph {

  public static int maxStarSum(int[] vals, int[][] edges, int k) {
    int n = vals.length;
    List<Integer>[] graph = new List[n];
    PriorityQueue<Integer>[] pq = new PriorityQueue[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
      pq[i] = new PriorityQueue((Comparator.reverseOrder()));
    }

    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
      pq[edge[0]].add(vals[edge[1]]);
      pq[edge[1]].add(vals[edge[0]]);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = vals[i];
      if (pq[i].size() < k) {
        ans = Math.max(ans, sum);
        continue;
      }
      int count = 0;
      while (count++ < k) {
        sum += pq[i].poll();
      }
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] vals = {-1, 0};
    int[][] edges = {};
    int k = 1;
    maxStarSum(vals, edges, k);
  }
}
