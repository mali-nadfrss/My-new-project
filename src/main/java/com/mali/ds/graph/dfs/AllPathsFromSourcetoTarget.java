package com.mali.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/all-paths-from-source-to-target/ */
public class AllPathsFromSourcetoTarget {

  static List<List<Integer>> ans;

  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(0, graph, list);
    return ans;
  }

  static void dfs(int current, int[][] graph, List<Integer> path) {
    path.add(current);
    if (current == graph.length - 1) {
      ans.add(new ArrayList<>(path));
    }
    for (int child : graph[current]) {
      dfs(child, graph, path);
    }
    path.remove(path.size() - 1);
  }

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    allPathsSourceTarget(graph);
  }
}
