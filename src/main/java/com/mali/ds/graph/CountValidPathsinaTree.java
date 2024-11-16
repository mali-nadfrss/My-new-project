package com.mali.ds.graph;

import java.util.*;

/* https://leetcode.com/contest/weekly-contest-364/problems/count-valid-paths-in-a-tree/ */
public class CountValidPathsinaTree {

  public static long countPaths(int n, int[][] edges) {
    primes(n);
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int[] edge : edges) {
      graph.putIfAbsent(edge[0], new HashSet<>());
      graph.putIfAbsent(edge[1], new HashSet<>());
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    recursion(graph, 1, 0);
    return ans;
  }

  static long ans = 0;

  static int[] recursion(Map<Integer, Set<Integer>> graph, int cur, int prev) {
    int[] values = new int[] {primes.contains(cur) ? 1 : 0, primes.contains(cur) ? 0 : 1};
    for (int edge : graph.get(cur)) {
      if (edge == prev) continue;
      int[] tempValues = recursion(graph, edge, cur);
      ans += values[0] * tempValues[1] + values[1] * tempValues[0];
      if (primes.contains(cur)) {
        values[0] += tempValues[1];
      } else {
        values[0] += tempValues[1];
        values[1] += tempValues[0];
      }
    }

    return values;
  }

  static Set<Integer> primes;

  static void primes(int n) {
    Set<Integer> nonPrimes = new HashSet<>();
    primes = new HashSet<>();
    nonPrimes.add(1);
    for (int i = 2; i <= n; i++) {
      if (!nonPrimes.contains(i)) {
        primes.add(i);
        for (int j = 2; j * i <= n; j++) {
          nonPrimes.add(j * i);
        }
      }
    }
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
    countPaths(n, edges);
  }
}
