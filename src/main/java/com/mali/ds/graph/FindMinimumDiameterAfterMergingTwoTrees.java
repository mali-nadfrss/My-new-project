package com.mali.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/ */
public class FindMinimumDiameterAfterMergingTwoTrees {

  public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

    int n = edges1.length + 1;
    int m = edges2.length + 1;

    int[] visit1 = new int[n];
    int[] visit2 = new int[m];



    Map<Integer, List<Integer>> graph1 = initGraph(edges1);
    Map<Integer, List<Integer>> graph2 = initGraph(edges2);

    List<Integer> leaves1 = getLeafs(graph1);
    List<Integer> leaves2 = getLeafs(graph2);

    int ans1 = findMaxDistance(leaves1.get(0), graph1, visit1);
    int ans2 = findMaxDistance(leaves2.get(0), graph2, visit2);
    return (ans1 + ans2) / 2 + 1;
  }

  static int findMaxDistance(int node, Map<Integer, List<Integer>> graph, int[] visited) {
    visited[node] = 1;
    int ans = 0;
    for (int n : graph.get(node)) {
      if (visited[n] == 0) {
        ans = Math.max(ans, findMaxDistance(n, graph, visited));
      }
    }
    return ans + 1;
  }

  static List<Integer> getLeafs(Map<Integer, List<Integer>> graph) {
    List<Integer> ans = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      if (entry.getValue().size() <= 1) {
        ans.add(entry.getKey());
      }
    }
    return ans;
  }

  static Map<Integer, List<Integer>> initGraph(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.putIfAbsent(edge[0], new ArrayList<>());
      graph.get(edge[0]).add(edge[1]);

      graph.putIfAbsent(edge[1], new ArrayList<>());
      graph.get(edge[1]).add(edge[0]);
    }
    return graph;
  }

  public static void main(String[] args) {
    int[][] edges1 = {{0, 1}, {0, 4}, {3, 5}, {6, 3}, {7, 6}, {2, 7}, {0, 2}, {8, 0}, {8, 9}};
    int[][] edges2 = {{3, 0}, {2, 1}, {2, 3}};
    System.out.println(minimumDiameterAfterMerge(edges1, edges2));
  }
}
