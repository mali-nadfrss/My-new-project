package com.mali.ds.graph.topo;

import java.util.*;
import java.util.stream.Collectors;

/* https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/ */
public class AllAncestorsofaNodeinaDirectedAcyclicGraph {

  public static List<List<Integer>> getAncestors(int n, int[][] edges) {

    int[] deg = new int[n];
    List<Integer>[] graph = new List[n];
    Set<Integer>[] ans = new Set[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
      ans[i] = new HashSet<>();
    }

    for (int[] road : edges) {
      graph[road[0]].add(road[1]);
      deg[road[1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (deg[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int child : graph[current]) {
        ans[child].addAll(ans[current]);
        ans[child].add(current);
        deg[child]--;
        if (deg[child] == 0) {
          queue.add(child);
        }
      }
    }

    List<List<Integer>> finalAns = new ArrayList<>();
    for (Set<Integer> a : ans) {
      List<Integer> list = new ArrayList<>();
      list.addAll(a);
      finalAns.add(list.stream().sorted().collect(Collectors.toList()));
    }

    return finalAns;
  }

  public static void main(String[] args) {
    int n = 8;
    int[][] edgeList = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
    getAncestors(n, edgeList);
  }
}
