package com.mali.ds.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* https://leetcode.com/contest/weekly-contest-365/problems/count-visited-nodes-in-a-directed-graph/ */
public class CountVisitedNodesinaDirectedGraph {

  public static int[] countVisitedNodes(List<Integer> edges) {
    int n = edges.size();
    int[] seen = new int[n];

    Set<Integer> circles = new HashSet<>();
    Set<Integer> leafs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      leafs.add(edges.get(i));
    }
    Set<Integer> nleafs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (!leafs.contains(i)) nleafs.add(i);
    }
    for (int i : nleafs) {
      int next = i;
      if (seen[i] != 0) continue;
      while (seen[next] == 0) {
        seen[next] = 1;
        next = edges.get(next);
      }
      circles.add(next);
    }

    for (int i = 0; i < n; i++) {
      int next = i;
      if (seen[i] != 0) continue;
      while (seen[next] == 0) {
        seen[next] = 1;
        next = edges.get(next);
      }
      circles.add(next);
    }

    int count = 0;
    for (int edge : circles) {
      count = 1;
      int cur = edges.get(edge);
      while (cur != edge) {
        count++;
        cur = edges.get(cur);
      }
      cur = edges.get(edge);
      seen[edge] = count;
      while (cur != edge) {
        seen[cur] = count;
        circles.add(cur);
        cur = edges.get(cur);
      }
    }
    for (int i = 0; i < n; i++) {
      if (circles.contains(i)) {
        continue;
      }
      seen[i] = recursion(seen, circles, i, edges);
    }
    return seen;
  }

  static int recursion(int[] seen, Set<Integer> circles, int cur, List<Integer> edges) {
    if (circles.contains(cur)) return seen[cur];
    return seen[cur] = 1 + recursion(seen, circles, edges.get(cur), edges);
  }

  public static void main(String[] args) {
    Integer[] edges = new Integer[] {7, 0, 7, 0, 5, 3, 3, 0};
    System.out.println(countVisitedNodes(Arrays.asList(edges)));
  }
}
