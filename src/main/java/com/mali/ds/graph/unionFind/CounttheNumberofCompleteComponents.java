package com.mali.ds.graph.unionFind;

import java.util.*;

/*https://leetcode.com/contest/weekly-contest-345/problems/count-the-number-of-complete-components/ */
public class CounttheNumberofCompleteComponents {

  public static int countCompleteComponents(int n, int[][] edges) {

    int[] parent = new int[n];
    int[] rank = new int[n];
    Set[] graph = new Set[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }

    for (int[] edge : edges) {
      if (graph[edge[0]] == null) graph[edge[0]] = new HashSet<>();
      if (graph[edge[1]] == null) graph[edge[1]] = new HashSet<>();
      graph[edge[0]].add(edge[1]);
      graph[edge[0]].add(edge[0]);

      graph[edge[1]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
      union(edge[0], edge[1], parent, rank);
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int p = find(parent[i], parent);
      map.putIfAbsent(p, new HashSet<>());
      map.get(p).add(i);
    }
    int ans = map.size();
    boolean flag = true;
    for (Set<Integer> set : map.values()) {
      for (int i : set) {
        flag = true;
        for (int j : set) {
          if (graph[i] != null && !graph[i].contains(j)) {
            ans--;
            flag = false;
            break;
          }
        }
        if (!flag) break;
      }
    }
    return ans;
  }

  static int find(int x, int[] parent) {
    if (parent[x] != x) {
      parent[x] = find(parent[x], parent);
    }
    return parent[x];
  }

  static void union(int a, int b, int[] parent, int[] rank) {

    int ap = find(a, parent);
    int bp = find(b, parent);

    if (ap != bp) {

      if (rank[ap] > rank[bp]) {
        parent[bp] = ap;
        rank[ap]++;
      } else {
        parent[ap] = bp;
        rank[bp]++;
      }
    }
  }

  public static void main(String[] args) {
   // int n = 6;
   // int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};

     int n = 4;
     int[][] edges = {{2,0},{3,1},{3,2}};
    countCompleteComponents(n, edges);
  }
}
