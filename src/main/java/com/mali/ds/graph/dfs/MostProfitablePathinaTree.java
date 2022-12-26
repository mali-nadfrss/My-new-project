package com.mali.ds.graph.dfs;

import java.util.LinkedList;
import java.util.List;

/* https://leetcode.com/contest/biweekly-contest-91/problems/most-profitable-path-in-a-tree/ */
public class MostProfitablePathinaTree {

  public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    int len = amount.length;
    List<Integer>[] graph = new List[len];
    List<Integer>[] bgraph = new List[len];
    for (int[] i : edges) {
      if (graph[i[0]] == null) {
        graph[i[0]] = new LinkedList<>();
      }
      if (bgraph[i[1]] == null) {
        bgraph[i[1]] = new LinkedList<>();
      }
      graph[i[0]].add(i[1]);
      bgraph[i[1]].add(i[0]);
    }
    boolean[] visited = new boolean[len];
    recursion(graph, bgraph, 0, bob, amount, 0, visited);
    return ans;
  }

  static int ans = Integer.MIN_VALUE;

  static void recursion(
      List<Integer>[] graph,
      List<Integer>[] bgraph,
      int alice,
      int bob,
      int[] amount,
      int val,
      boolean[] visited) {
    if (graph[alice] == null) {
      ans = Math.max(ans, val);
      return;
    }
    if (!visited[alice] && !visited[bob]) {
      if (alice == bob) val += amount[alice] / 2;
      else val += amount[alice];
    }
    visited[alice] = true;
    visited[bob] = true;

    for (int k : graph[alice]) {
      if (bgraph[bob] != null) {
        for (int j : bgraph[bob]) {
          recursion(graph, bgraph, k, j, amount, val, visited);
          visited[j] = false;
        }
      }
      visited[k] = false;
    }
  }

  public static void main(String[] args) {

    int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
    int bob = 3;
    int[] amount = {-2, 4, 2, -4, 6};
    System.out.println(mostProfitablePath(edges, bob, amount));
  }
}
